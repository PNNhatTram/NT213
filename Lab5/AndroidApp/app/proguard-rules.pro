# Firebase Database rules
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**
-keepattributes Signature

# Parcelable and DataSnapshot classes
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class com.google.firebase.database.DataSnapshot {
    public <methods>;
}

# Models used in Firebase (e.g., User class)
-keepclassmembers class com.example.androidapp.model.* {
    <fields>;
}

# AppCompatActivity and related classes
-keep public class * extends android.app.Activity
-keep public class * extends androidx.appcompat.app.AppCompatActivity

# Android SDK rules
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Prevent obfuscation of methods used in XML
-keepclassmembers class * {
    public void *(android.view.View);
}

# Prevent obfuscation of Reflection APIs
-keepclassmembers class * {
    public void set*(***);
    public *** get*(***);
}

# Optimize code and remove unused classes
# Remove the next two lines to enable optimization and obfuscation
# -dontoptimize
# -dontobfuscate

# General rules to minimize APK size
-optimizationpasses 5
# -overloadaggressively # Commented out for safety, test before enabling

# Remove logs in production
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** w(...);
    public static *** e(...);
    public static *** v(...);
    public static *** i(...);
}
