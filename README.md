# Usage and Billing System

## 1. About the Project
This is a simple Java console-based project for managing meeting room usage. It allows users to start and stop sessions, check room availability, and calculate bills based on usage time.

## 2. Data Structures Used
- **HashMap (active):** Stores session IDs and their start times.
- **HashMap (users):** Stores session IDs and the corresponding user IDs.
- **Scanner:** Takes input from the user.

## 3. Logic and Approach
- View Room: Displays room capacity and available slots.
- Start Usage: Checks availability, validates the user, generates a session ID, and records the start time.
- Stop Usage: Calculates the usage duration and bill, then releases the slot.
- Exit: Closes the program.

The first hour costs Rs. 30, and each additional billable hour costs Rs. 10. Any extra time is rounded up to the next hour.

## 4. How to Run
1. Install Java JDK.
2. Open the project folder in the terminal.
3. Compile the program:

   ```bash
   javac UsageAndBillingSystem.java
   ```

4. Run the program:

   ```bash
   java UsageAndBillingSystem
   ```

## 5. Testing
- Check room capacity and available slots.
- Start sessions and test the capacity limit.
- Try starting a duplicate active session.
- Enter an invalid session ID.
- Stop a session and verify the duration, bill, and slot availability.

## 6. Assumptions and Technical Details
- The meeting room ID is `R101`, with a capacity of two active sessions.
- A user can have only one active session at a time.
- Session IDs are generated automatically, starting from `S101`.
- Data is stored in memory using HashMaps; no database is used.
- Stopped sessions are removed, so billing history is not saved.
- Time is calculated using Java's `Instant` and `Duration` classes.