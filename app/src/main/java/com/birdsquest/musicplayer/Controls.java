package com.birdsquest.musicplayer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Controls extends RelativeLayout{
	boolean showArtBig=false,showArtSmall=false,showSeek=false,showRec=false,showStop=false, secondRow=false, thirdRow=false;

	public Controls(Context context){super(context);init(context,null);}
	public Controls(Context context, AttributeSet attrs){super(context, attrs);init(context,attrs);}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
		View button=findViewAtPosition(getRootView(), (int)event.getRawX(), (int)event.getRawY());
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			button.setPressed(true);
			//((ImageView)button).setSelected(true);
		}
		if(event.getAction() == MotionEvent.ACTION_UP){
			button.setPressed(false);
			if(button!=null){
				int id=button.getId();
				switch(id){
					//First Row
					case R.id.control_prev: Prev(); break;
					case R.id.control_playpause: PlayPause((ImageView)button); break;
					case R.id.control_stop: Stop(); break;
					case R.id.control_next: Next(); break;
					case R.id.control_rec: Record(); break;
					//Second Row
					case R.id.control_repeat: ToggleRepeat(); break;
					case R.id.control_shuffle: ToggleShuffle(); break;
					case R.id.control_voldown: VolDown(); break;
					case R.id.control_volup: VolUp(); break;
					case R.id.control_mute: Mute(); break;
				}
			}
			return performClick();
		}
		return true;
	}
	private View findViewAtPosition(View parent, int x, int y) {
		if (parent instanceof ViewGroup) {
			ViewGroup viewGroup = (ViewGroup)parent;
			for (int i=0; i<viewGroup.getChildCount(); i++) {
				View child = viewGroup.getChildAt(i);
				View viewAtPosition = findViewAtPosition(child, x, y);
				if (viewAtPosition != null) {
					return viewAtPosition;
				}
			}
			return null;
		} else {
			Rect rect = new Rect();
			parent.getGlobalVisibleRect(rect);
			if (rect.contains(x, y)) {
				return parent;
			} else {
				return null;
			}
		}
	}
	public void init(Context context, AttributeSet attrs){
		View.inflate(context, R.layout.controls,this);
		if(attrs!=null){
			TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.Controls);
			try {
				showArtBig=a.getBoolean(R.styleable.Controls_showArtBig, false);
				showArtSmall=a.getBoolean(R.styleable.Controls_showArtSmall, false);
				showSeek=a.getBoolean(R.styleable.Controls_showSeek, false);
				showRec=a.getBoolean(R.styleable.Controls_showRec, false);
				showStop=a.getBoolean(R.styleable.Controls_showStop, false);
				secondRow=a.getBoolean(R.styleable.Controls_secondRow, false);
				thirdRow=a.getBoolean(R.styleable.Controls_thirdRow, false);
			} finally {
				a.recycle();
			}
		}
		if(!showArtBig){findViewById(R.id.albumArtBig).setVisibility(View.GONE);}
		if(!showArtSmall){findViewById(R.id.albumArtSmall).setVisibility(View.GONE);}
		if(!showSeek){findViewById(R.id.seekBar).setVisibility(View.GONE);}
		if(!showRec){findViewById(R.id.control_rec).setVisibility(View.GONE);}
		if(!showStop){findViewById(R.id.control_stop).setVisibility(View.GONE);}
		if(!secondRow){findViewById(R.id.control_secondRow).setVisibility(View.GONE);}
		if(!thirdRow){findViewById(R.id.control_thirdRow).setVisibility(View.GONE);}
	}

	/** First Row Controls */
	public void Prev(){
		Toast.makeText(this.getContext(), "Prev", Toast.LENGTH_SHORT).show();
	}
	public void PlayPause(ImageView button){
		Toast.makeText(this.getContext(), "PlayPause", Toast.LENGTH_SHORT).show();
	}
	public void Stop(){
		Toast.makeText(this.getContext(), "Stop", Toast.LENGTH_SHORT).show();
	}
	public void Next(){
		Toast.makeText(this.getContext(), "Next", Toast.LENGTH_SHORT).show();
	}
	public void Record(){
		Toast.makeText(this.getContext(), "Record", Toast.LENGTH_SHORT).show();
	}

	/** Second Row Controls */
	public void ToggleRepeat(){
		Toast.makeText(this.getContext(), "ToggleRepeat", Toast.LENGTH_SHORT).show();
	}
	public void ToggleShuffle(){
		Toast.makeText(this.getContext(), "ToggleShuffle", Toast.LENGTH_SHORT).show();
	}
	public void VolDown(){
		Toast.makeText(this.getContext(), "VolDown", Toast.LENGTH_SHORT).show();
	}
	public void VolUp(){
		Toast.makeText(this.getContext(), "VolUp", Toast.LENGTH_SHORT).show();
	}
	public void Mute(){
		Toast.makeText(this.getContext(), "Mute", Toast.LENGTH_SHORT).show();
	}
}
