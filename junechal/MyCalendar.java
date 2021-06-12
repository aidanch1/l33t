package junechal;
import java.util.*;

public class MyCalendar {
	List<Booking> bookings;
    
    public MyCalendar() {
        bookings = new ArrayList<>();        
    }
    
    public boolean book(int start, int end) {
        if (bookings.size() == 0) {
            bookings.add(new Booking(start, end));
            return true;
        }
        int index = getIndex(start);
        if (index < 0) {
            if (bookings.get(0).start >= end) {
                bookings.add(0, new Booking(start, end));
                return true;
            }
            else {
                return false;
            }
        }
        if (index == bookings.size()-1) {
            if (bookings.get(index).end <= start) {
                bookings.add(new Booking(start, end));
                return true;
            }
            else {
                return false;
            }
        }
        if (bookings.get(index).end <= start && bookings.get(index+1).start >= end) {
            bookings.add(index+1, new Booking(start, end));
            return true;
        }
        return false;
    }
    
    public int getIndex(int start) {
        //index of booking who's start time is just less than start
        int left = 0;
        int right = bookings.size()-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (bookings.get(mid).start == start) {
                return mid;
            }
            else if (bookings.get(mid).start < start) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return right;
    }
}
class Booking {
    int start;
    int end;
    public Booking(int a, int b) {
        start = a;
        end = b;
    }
}