package com.feicuiedu.android.imageloaderdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;

public class LoadImage {	
	//private static Map<String, SoftReference<Bitmap>> softReferences=new HashMap<String, SoftReference<Bitmap>>();
	
	// 参照理解 http://www.2cto.com/kf/201502/376042.html
	private static LruCache<String, Bitmap> cache=new LruCache<String, Bitmap>(1024*1024*3);
	
	private Context context;
	private ImageLoadListener listener;
	public LoadImage(Context context,ImageLoadListener listener){
		this.context=context;
		this.listener=listener;
	}
	
	public interface ImageLoadListener{
		void imageLoadOk(Bitmap bitmap, String url);
	}
	
	public Bitmap geBitmap(String url){
		Bitmap bitmap=null;
		if(url==null || url.length()<=0)
			return bitmap;
		//1.先看看内存中有没有  
		bitmap=getBitmapFromReference(url);
		if(bitmap!=null){
			System.out.println("1.内存中的图片");
			return bitmap;
		}
		//2.去看看缓存文件有没有
		bitmap=getBitmapFromCache(url);
		if(bitmap!=null){
			//存入内存
			//softReferences.put(url, new SoftReference<Bitmap>(bitmap));
			cache.put(url, bitmap);
			System.out.println("2.缓存中的图片");
			return bitmap;
		}
		//3.异步加载 
		getBitmapAsync(url);		
		return bitmap;
	}

	private void getBitmapAsync(String url) {
		ImageAsyncTask imageAsyncTask=new ImageAsyncTask();
		imageAsyncTask.execute(url);
	}

	private Bitmap getBitmapFromCache(String url) {
		//http://www.baidu.com/gejge/jgejg/gg.jpg
		String name=url.substring(url.lastIndexOf("/")+1);
		//File cacheDir=context.getCacheDir();
		File cacheDir=context.getExternalCacheDir();
		if(cacheDir==null)return null;
		File[] files=cacheDir.listFiles();
		if(files==null){
			return null;
		}
		File bitmapFile=null;
		for (File file : files) {
			if(file.getName().equals(name)){
				bitmapFile=file;
				break;
			}
		}
		if(bitmapFile==null){
			return null;
		}
		Bitmap bitmap=BitmapFactory.decodeFile(bitmapFile.getAbsolutePath());
		if(bitmap==null)
			return null;
		return bitmap;
	}

	private Bitmap getBitmapFromReference(String url) {
		Bitmap bitmap=null;
//		if(softReferences.containsKey(url)){
//			bitmap=softReferences.get(url).get();
//		}
		bitmap=cache.get(url);
		return bitmap;
	}

	private class ImageAsyncTask extends AsyncTask<String, Void, Bitmap>{
		private String url;

		@Override
		protected Bitmap doInBackground(String... params) {
			url=params[0];
			//params[0]--->url
			Bitmap bitmap=null;
			try {
				URL url=new URL(params[0]);
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				InputStream is=conn.getInputStream();
				bitmap=BitmapFactory.decodeStream(is);		
//				//软引用 
//				softReferences.put(params[0], new SoftReference<Bitmap>(bitmap));
//				System.out.println(softReferences.size());
				cache.put(params[0], bitmap);
				//缓存文件
				saveCacheFile(params[0],bitmap);
				System.out.println("3.网络中的图片");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			if(listener!=null){
				listener.imageLoadOk(result,url);
			}
		}		
	}

	public void saveCacheFile(String url,Bitmap bitmap) {
		String name=url.substring(url.lastIndexOf("/")+1);
		//File cacheDir=context.getCacheDir();
		File cacheDir=context.getExternalCacheDir();
		if(!cacheDir.exists()){
			cacheDir.mkdirs();
		}
		OutputStream stream;
		try {
			stream = new FileOutputStream(new File(cacheDir, name));
			bitmap.compress(CompressFormat.JPEG, 100, stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
