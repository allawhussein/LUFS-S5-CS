# Chapter 1: Getting Started With Android Programming

## Introduction

### Mobile Application Development Points of Interest
- UX
- using least permissions
- account for multiple image resolutions
- memory & battery usage
- bandwidth usage
- error/exception management
- code quality

### App Publication
1. create a developer account
2. Upload the app (binary and metadata)
3. track app status

### Android features
- Dalvik virtual machine
- integrated browser 
- optimized graphics (powered by custom 2D and 3D graphics libraries)
- SQLite
- Media support
- GSM telephony
- Bluetooth, WiFi, 4G
- Camera, GPS, compass, accelerometer
- Rich development environment

## `Main Activity.java`
```java
package com.example.numberguess;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```
when `setContentView` is called, it links the application to the layout file `R.layout.activity_main`, and display the widgets on the application main screen.
# Chapter 2: Android Widgets
It includes: buttons, clock, gallery, web/map view, spinner, progress bar, ...

## Button
A clickable widget with text label.
### Key Attributes:
```xml
<Button
    android:clickable="bool"
    set to false to disable button.
    android:id="@+id/theID"
    unique ID for linking with java code
    android:onClick="function"
    the function to call upon button pressing, the function must be `public void` and take a view argument
    android:text="text"
    test to be displayed in the button.
/>
```
These attributes are set by the XML file, and can be modified by the design view of XML editor in android studio. Below is an example from [Project 2](./App/Project_2/)
```java
Button btn = (Button) findVeiwById(R.id.theID);
// findViewById is the superclass of Button class
```

## Image Button
### Key attributes
Same as text button but instead of text attribute we have image source attribute:
```xml
<ImageButton
    android:clickable="bool"
    set to false to disable button.
    android:id="@+id/theID"
    unique ID for linking with java code
    android:onClick="function"
    the function to call upon button pressing, the function must be `public void` and take a view argument
    android:text="text"
    test to be displayed in the button.
    android:src="@drawable/img"
    all images and icons should be place inside `res/drawable`, when referencing the image, the extension should be dropped from the image name.
/>
```
## Image View
similar to image button, but of course not clickable, only ID and src attributes are present.


To change the image from the java code
```java

```

# EditText
```xml
<EditText
    android:id="@+id/editTextTextPersonName"
    android:hint="text"
    gray text to be shown to the user when nothing is typed
    android:inputType="type"
    what kind of input is being submitted (number, phone, date, time)
    android:lines="int"
    number of lines to be shown    
/>
```

## Simple Text Copy Application
```java
package com.example.numberguess;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    TextView outputtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.inputText);
        outputtxt = findViewById(R.id.txtMessage);
    }

    public void copy(view v){
        String text = txt.getText().toString();
        outputtxt.settext(text);
    }
}
```

# Spinner Activity

there's three methods, the second is where the spinner extends `Activity` and implements `OnItemSelectedListener`.
The thirs method was explained yesterday