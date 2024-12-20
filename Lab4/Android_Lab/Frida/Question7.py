import frida
import sys # import sys
import time

device=frida.get_usb_device()
pid=device.spawn("com.android.insecurebankv2")
device.resume (pid)

time.sleep(1) # sleep 1 to avoid crash (sometime)

session=device.attach(pid)

hook_script="""
Java.perform(function () {
    console.log("Inside the hook_script");
    var classPostLogin = Java.use('com.android.insecurebankv2.PostLogin');
    classPostLogin.doesSuperuserApkExist.implementation = function()
    {
        return true; //code execute
    };
});
"""

script=session.create_script(hook_script)
script.load()

input('Press Ctrl + C to exit')
sys.stdin.read() # maintain the hook’s execution until end (manually)