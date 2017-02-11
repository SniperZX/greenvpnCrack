package com.hypering.greenvpncrack;

import android.util.Log;

import java.util.UUID;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by zhaohongru on 2017-02-07.
 * PackageName: com.hypering.greenvpncrack.XModule
 * Description：
 */
public class XModule implements IXposedHookLoadPackage{
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if(!loadPackageParam.packageName.equals("com.vpn.green")&&!("com.vpn.uuu").equals(loadPackageParam.packageName)){
            Log.i("xposed", "不符合");
            return;
        }
        Log.i("xposed", "符合");
        if(loadPackageParam.packageName.equals("com.vpn.green")) {
            XposedHelpers.findAndHookMethod("com.vpn.green.utils.SharedPreferencesHelper", loadPackageParam.classLoader, "get", String.class, Object.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    System.out.println("开始hook");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    if (param.args[0].equals("share_key_expiretime")) {
                        param.setResult("never give up");
                    }
                    //share_key_isreceive

                    if (param.args[0].equals("url_key_error")) {
                        param.setResult("never give up");
                    }

                    if (param.args[0].equals("share_key_userid")) {
                        System.out.println("share_key_userid");
                        param.setResult(UUID.randomUUID().toString().substring(0, 10));
                    }
                    if (param.args[0].equals("share_key_sessionid")) {
                        System.out.println("share_key_sessionid");
                        param.setResult(UUID.randomUUID().toString().substring(0, 10));
                    }
                    //share_key_vpn
                    System.out.println("结束hook");
                }
            });

            XposedHelpers.findAndHookMethod("com.vpn.green.receiver.GreenService", loadPackageParam.classLoader, "onCreate", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                    System.out.println("去掉oncreate");
                    return null;
                }
            });


        }
//SharedPreferencesHelper
        if(loadPackageParam.packageName.equals("com.vpn.uuu")) {
            XposedHelpers.findAndHookMethod("com.vpn.uuu.utils.SharedPreferencesHelper", loadPackageParam.classLoader, "get", String.class, Object.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    System.out.println("开始hook");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    if (param.args[0].equals("share_key_expiretime")) {
                        param.setResult("never give up11");
                    }
                    //share_key_isreceive
                    if (param.args[0].equals("share_key_isreceive")) {
                        param.setResult(false);
                    }
                    if (param.args[0].equals("url_key_error")) {
                        param.setResult("never give up");
                    }
                    if (param.args[0].equals("share_key_vpn")) {
                        System.out.println("share_key_vpn");
                        param.setResult(true);
                    }
                    if (param.args[0].equals("share_key_userid")) {
                        System.out.println("share_key_userid");
                        param.setResult(UUID.randomUUID().toString().substring(0, 10));
                    }
                    if (param.args[0].equals("share_key_sessionid")) {
                        System.out.println("share_key_sessionid");
                        param.setResult(UUID.randomUUID().toString().substring(0, 10));
                    }
                    //share_key_vpn
                    System.out.println("结束hook");
                }
            });

            XposedHelpers.findAndHookMethod("com.vpn.uuu.receiver.UUUService", loadPackageParam.classLoader, "onCreate", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                    System.out.println("去掉oncreate");
                    return null;
                }
            });

        }
//        XposedHelpers.findAndHookMethod("android.telephony.TelephonyManager", loadPackageParam.classLoader, "getDeviceId", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//                System.out.println("开始hook serviceStop");
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//                Random random = new Random();
//                UUID uuid = UUID.randomUUID();
//                param.setResult(uuid.toString());
//                System.out.println("开始hook getDeviceId");
//            }
//        });
//        XposedHelpers.findAndHookMethod("android.content.Context", loadPackageParam.classLoader, "currentTimeMillis", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//                System.out.println("开始hook serviceStop");
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//                param.setResult(1111l);
//            }
//        });



    }



}
