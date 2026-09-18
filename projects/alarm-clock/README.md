# Java OOP Practice — Alarm Clock

A small console alarm-clock project that demonstrates basic object-oriented Java concepts:

- separating application startup (`Main`) from the alarm worker (`AlarmClock`)
- implementing `Runnable` and running work on a separate thread
- parsing time input with `LocalTime` and `DateTimeFormatter`
- playing audio through the Java Sound API

## Project layout

```
src/main/java/com/alanjosephalex/oop/alarm/
  Main.java
  AlarmClock.java
assets/audio/
  .gitkeep
```

## Requirements

- JDK 11 or newer
- A local WAV alarm file

## Run it

1. Put a WAV file at `assets/audio/Keep It Movin' - Jahdean.wav`, or change `filePath` in `Main.java` to match your own file.
2. Compile the files under `src/main/java`.
3. Run `com.alanjosephalex.oop.alarm.Main`.
4. Enter an alarm time in `HH:mm:ss` format, for example `07:30:00`.

Audio files are intentionally excluded from version control, keeping the repository focused on the code and letting each user supply audio they are permitted to use.
