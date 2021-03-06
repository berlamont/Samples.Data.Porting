/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 */

package com.microsoft.azure.engagement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * This receiver is needed to make the real time location reporting starts in background as soon as
 * the device boots. To use it in your application you need to add the following section in your
 * AndroidManifest.xml file:
 * 
 * <pre>
 * {@code <receiver android:name="com.microsoft.azure.engagement.EngagementLocationBootReceiver" android:exported="false">
 *   <intent-filter>
 *     <action android:name="android.intent.action.BOOT_COMPLETED" />
 *   </intent-filter>
 * </receiver>}
 * 
 * If missing, add the following permission:<br/>
 * {@code <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />}
 */
public class EngagementLocationBootReceiver extends BroadcastReceiver
{
  @Override
  public void onReceive(Context context, Intent intent)
  {
    /* Just ensure the service starts and restore background location listening if enabled */
    context.startService(EngagementAgentUtils.getServiceIntent(context));
  }
}
