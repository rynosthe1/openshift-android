package com.openshift.android.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.openshift.android.R;
import com.openshift.android.model.ApplicationAliasResource;
import com.openshift.android.model.ApplicationResource;
import com.openshift.android.model.CartridgeResource;
import com.openshift.android.util.ImageUtils;

/**
 * Adapter which provides a menu of Openshift Applications for a User
 * 
 * @author Andrew Block
 * 
 * @see ArrayAdapter
 * @see ApplicationResource
 *
 */
public class ApplicationAdapter extends ArrayAdapter<ApplicationResource> {

	private List<ApplicationResource> objects;
	private Context context;
	
	public ApplicationAdapter(Context context, int textViewResourceId,
			List<ApplicationResource> objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects;
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		
		View vi = convertView;
		
		if(vi == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vi = inflater.inflate(R.layout.application_row_layout, parent, false);
		}
		
		ApplicationResource application = objects.get(position);
		
		ImageView applicationLogo = (ImageView) vi.findViewById(R.id.applicationListImageView);
		applicationLogo.setImageResource((ImageUtils.getImageResourceId(context, application.getFramework())));
		
		TextView appName = (TextView) vi.findViewById(R.id.appName);
		appName.setText(application.getName());
		
		TextView appUrl = (TextView) vi.findViewById(R.id.appUrl);
		appUrl.setText(application.getApplicationUrl());
		
		return vi;
		
	}
	


}
