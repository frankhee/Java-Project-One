/**
 * SimpleClock.java
 *
 * A class that implements a simple
 *
 * @author Frank He
 *
 */
package osu.cse1223;

public class SimpleClock {

	/* -------- Private member variables --------------------- */
	private int hours;
	private int minutes;
	private int seconds;
	private boolean morning;

	/* -------- Constructor --------------------------------- */
	/**
	 * The constructor should set the initial value of the clock to 12:00:00AM.
	 */
	public SimpleClock() {

		this.hours = 12;
		this.minutes = 0;
		this.seconds = 0;
		this.morning = true;

	}

	/* --------- Instance methods ------------------------- */

	/**
	 * Sets the time showing on the clock.
	 * 
	 * @param hh
	 *            - the hours to display
	 * @param mm
	 *            - the minutes to display
	 * @param ss
	 *            - the seconds to display
	 * @param morning
	 *            - true for AM, false for PM
	 */
	public void set(int hh, int mm, int ss, boolean morning) {

		// Set up instance methods and determine the validity of the input values
		if (hh > 0 && hh < 13) {
			this.hours = hh;
		}

		// If input not valid, default the hour to 11
		else {
			this.hours = 11;
		}
		if (mm >= 0 && mm < 60) {
			this.minutes = mm;
		}

		// If input not valid, default the minutes to 59
		else {
			this.minutes = 59;
		}
		if (ss >= 0 && ss < 60) {
			this.seconds = ss;
		}

		// If input not valid, default the seconds to 0
		else {
			this.seconds = 0;
		}
		this.morning = morning;
	}

	/**
	 * Advances the clock by 1 second. Make sure when implementing this method that
	 * the seconds "roll over" correctly - 11:59:59AM should become 12:00:00PM for
	 * example.
	 */
	public void tick() {

		// Increment seconds by one
		seconds++;

		// If seconds hit 60, increase minutes by 1 and reset seconds to 0
		if (seconds == 60) {
			seconds = 0;
			minutes++;

			// If minutes hits 60, increase hours by 1 and reset minutes to 0
			if (minutes == 60) {
				minutes = 0;
				hours++;

				// If hours hits 13, reset hours to 1
				if (hours == 13) {
					hours = 1;
					;
				}

				// If hours hits 12, minutes hits 0, and seconds hit 0, change the boolean
				// function morning to its opposite
				else if (minutes == 0 && hours == 12 && seconds == 0) {
					morning = !morning;
				}
			}
		}
	}

	/**
	 * Returns a string containing the current time formatted as a digital clock
	 * format. For example, midnight should return the string "12:00:00AM" while one
	 * in the morning would return the string "1:00:00AM" and one in the afternoon
	 * the string "1:00:00PM".
	 *
	 * @return - the current time formatted in AM/PM format
	 */
	public String time() {

		// Set up string time and parse time integers to strings
		String time;
		String second = Integer.toString(seconds);
		String minute = Integer.toString(minutes);
		String hour = Integer.toString(hours);

		// Set up the time format
		if (seconds < 10) {
			second = "0" + second;
		}
		if (minutes < 10) {
			minute = "0" + minute;
		}

		// Determine AM or PM based on the morning boolean function
		if (morning) {
			time = hour + ":" + minute + ":" + second + " AM";
		} else {
			time = hour + ":" + minute + ":" + second + " PM";

		}

		return time;
	}
}