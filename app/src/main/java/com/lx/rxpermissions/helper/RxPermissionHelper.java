package com.lx.rxpermissions.helper;

import android.app.Activity;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Action;


/**
 * Created on 17-8-9 下午4:22
 */

public class RxPermissionHelper {

//    /**Call at activity method of execution
//     * @param activity
//     * @param permission
//     * @param listener
//     */
//    public static void requestPermission(Activity activity, PermissionRequestListener listener, String... permission) {
//
//        new RxPermissions(activity).request(permission).subscribe((p) -> listener.onPermissionGrant(permission));
//
//
//        new RxPermissions(activity).requestEach(permission).subscribe(s-> {
//            if (s.equals(Permission.class))
//        });
//
//    }



}
