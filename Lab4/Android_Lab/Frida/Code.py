import frida 
import sys # import sys
import time

device = frida.get_usb_device()
pid = device.spawn(["com.android.insecurebankv2"])
device.resume(pid)

time.sleep(1)  # sleep 1 to avoid crash (sometimes)

session = device.attach(pid)
hook_script = """
Java.perform(function() {
    console.log("Inside the hook_script");
    var cryptoClass = Java.choose('com.android.insecurebankv2.CryptoClass', {
        onMatch: function(instance) {
            console.log("Found instance " + instance);
            console.log("Result decrypt: " + instance.aesDeccryptedString("v/sJpihDCo2ckDmLW5Uwiw=="));
        },
        onComplete: function() {
            console.log("end");
        }
    });
});
"""

script = session.create_script(hook_script)
script.load()

input('Press Ctrl + C to exit')
sys.stdin.read() # maintain the hook’s execution until end (manually)
