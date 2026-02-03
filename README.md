

# Android PdfViewer

A powerful library for displaying PDF documents on Android, featuring animations, gestures, zoom, and double-tap support. This library is based on [PdfiumAndroid](https://github.com/barteksc/PdfiumAndroid) for efficient PDF decoding.


## GitHub Stats

![GitHub stars](https://img.shields.io/github/stars/iamyashchouhan/AndroidPdfViewer?style=social)
![GitHub forks](https://img.shields.io/github/forks/iamyashchouhan/AndroidPdfViewer?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/iamyashchouhan/AndroidPdfViewer?style=social)
![GitHub issues](https://img.shields.io/github/issues/iamyashchouhan/AndroidPdfViewer)



## Installation

### Step 1: Add Repositories

Add the following to your root `build.gradle` file to include the necessary repositories:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add Dependency

Include the library in your app-level `build.gradle`:

```groovy
dependencies {
    implementation 'com.github.iamyashchouhan:AndroidPdfViewer:1.0.4' // latest
}
```

## 🚀 New in This Version

### 16 KB Page Size Support ✅ FIXED

✅ **RESOLVED:** This library has been updated to support 16 KB page sizes for Google Play compatibility.
Starting **November 1st, 2025**, all new apps and updates targeting Android 15+ must support 16 KB page sizes.

**What Was Fixed:**

* **Issue:** The `pdfium-android:1.9.0` dependency contained prebuilt native libraries that were not aligned for 16 KB page sizes
* **Solution:** Implemented compressed shared libraries configuration and post-build realignment scripts
* **Result:** APK now passes all 16 KB alignment checks and is Google Play compliant

**Key Updates Made:**

* **AGP Version:** Using 8.13.0 (above required 8.5.1)
* **NDK Version:** Updated to r28+ for 16 KB support
* **Packaging:** Configured for compressed shared libraries to avoid alignment issues
* **Native Libraries:** All native libraries are properly aligned for 16 KB page sizes
* **Realignment Scripts:** Added automated tools to fix alignment issues

**✅ Verification:**
Use the provided scripts to verify 16 KB alignment:

* **Linux/macOS:**

```bash
./check_16kb_alignment.sh your-app.apk
```

* **Windows:**

```powershell
.\check_16kb_alignment.ps1 -ApkFile "your-app.apk"
```

**Fix Alignment:**

```powershell
.\realign_apk.bat "your-app.apk"
```

**🎉 Google Play Compliance:**
Your app will now pass Google Play's 16 KB compatibility checks and work on devices with 16 KB page sizes.

```


## Usage

### Include PDFView in Your Layout

Add the `PDFView` component to your XML layout:

```xml
<com.ymg.pdf.viewer.PDFView
    android:id="@+id/pdfView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

### Load a PDF File

You can load a PDF file using various methods. Here are the available options:

```java
pdfView.fromUri(Uri uri) // Load from a URI
    .fromFile(File file) // Load from a file
    .fromBytes(byte[] bytes) // Load from byte array
    .fromStream(InputStream stream) // Load from InputStream
    .fromSource(DocumentSource source) // Load from a DocumentSource
    .fromAsset("filename.pdf") // Load from assets
    .pages(0, 2, 1, 3, 3, 3) // Specify which pages to display
    .enableSwipe(true) // Enable swipe for page navigation
    .swipeHorizontal(false) // Set swipe direction
    .enableDoubletap(true) // Enable double-tap to zoom
    .defaultPage(0) // Set the default page to display
    .onDraw(onDrawListener) // Callback for custom drawing
    .onLoad(onLoadCompleteListener) // Callback when loading is complete
    .onPageChange(onPageChangeListener) // Callback for page changes
    .onError(onErrorListener) // Callback for errors
    .load(); // Trigger the loading
```

### Additional Options

You can customize the behavior and appearance of the PDF viewer with these options:

- **Bitmap Quality**: By default, the generated bitmaps are compressed with `RGB_565`. Use `pdfView.useBestQuality(true)` to switch to `ARGB_8888`.

- **Double Tap Zooming**: 
  - Default zoom levels are:
    - Min: 1.0
    - Mid: 1.75
    - Max: 3.0
  - You can customize the zoom levels using:
    ```java
    pdfView.setMinZoom(float zoom);
    pdfView.setMidZoom(float zoom);
    pdfView.setMaxZoom(float zoom);
    ```

## Example Configuration

Here’s a complete example to get you started:

```java
PDFView pdfView = findViewById(R.id.pdfView);
pdfView.fromAsset("sample.pdf")
    .enableSwipe(true)
    .swipeHorizontal(false)
    .enableDoubletap(true)
    .defaultPage(0)
    .onLoad(new OnLoadCompleteListener() {
        @Override
        public void loadComplete(int nbPages) {
            // Handle loading completion
        }
    })
    .load();
```

## Conclusion

This library simplifies the process of displaying PDF documents in your Android applications while offering robust features and customization options. For more details, feel free to explore the documentation or contribute to the project.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

© 2024 iamyashchouhan, YMG-Developers

