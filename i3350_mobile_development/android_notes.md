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

# Widget Box Model
very similar to HTML element model, content surrounded by padding, surrounded by border, surrounded by margin.
## Sizing an individual element
element's width and height can be a specific value, `match_parent` (like 100% in HTML) and `wrap_content`.
## Padding
```xml
android:padding="match_parent"
android:paddingLeft="wrap_content"
...
```

# Layouts
some language require absolute positioning (like C++ & C#), others require a layout manager (like java), thus we need a layout manager for android development even if we want to use absolute positioning.

XML is the bridge between our code and the layout manager, it is used for describing hierarchical text data.

The root of XML is root manager (Constraint layout, linear layout).
## Linear Layouts
(already seen)
- direction
- gravity `android:gravity="vertical|horizontal"`  
    can specified for the whole layout or for a single element
- weight  
    it determine the spacing taken by the element relative to other elements  
    if weight is omitted then the height of each object will be used to determine the spacing of the element  
    if only one element has its weight specified, then all other elements will occupy their height, and this element will occupy whatever is left.

## Grid Layout
It's the successor of table layout
```xml
<GridLayout ...
    android:rowCount="2"
    android:columnCount="3">
    <Button ... android:text="Buton 1" />
    <Button ... android:text="Buton 2" />
    <Button ... android:text="Buton 3" 
                android:layout_rows="1"
                android:layout_columns="2"/>
    <Button ... android:text="Buton 4" />
</GridLayout>
```
if elements positioning in the grid is not specified, they'll occupy each cell if it can accomdate for them.  
there's a spaning command.

Layouts can be nested in each other.

## Relative Layout
## Frame Layoute

# Log Methods
## Log Methods
```java
Log.d("tag", "message"); // debug message
Log.e("tag", "message"); // error message
Log.d("tag", "message"); // debug message
Log.d("tag", "message"); // debug message
Log.d("tag", "message"); // debug message
```

# Apps Memory and Storge

# Activity State
1. started  
    In process of loading up, but not fully loaded
2. running  
    fully loaded and viewed on screen
3. paused  
    out of focus or obscured, but not shutted down.
4. stopped  
    No longer active, but still in memory (like apps in recent applications tab).
5. destroyed   
    shutted down and not found in active memory.

we can implement something in the transition from state to state.  
The first function that launches with our program is the `onCreate` public void method. others are:
1. from stopped to running
    - `onRestart()`
    - `onStart()`
    - `onResume()`
2. from starting to running
    - `onCreate()`
    - `onStart()`
    - $\dots$

$\dots$

