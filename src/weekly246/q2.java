package weekly246;

public class q2 {
	public int numberOfRounds(String startTime, String finishTime) {
        // round starttime up and finishtime down
        time s = new time(startTime);
        time f = new time(finishTime);
        if (s.hr==f.hr && f.min>s.min && f.min-s.min<15) {
            return 0;
        }
        if (s.min > 0 && s.min < 15) {
            s.min = 15;
        }
        else if (s.min > 15 && s.min < 30) {
            s.min = 30;
        }
        else if (s.min > 30 && s.min < 45) {
            s.min = 45;
        }
        else if (s.min > 45) {
            s.hr++;
            s.min = 0;
        }
        if (f.min > 0 && f.min < 15) {
            f.min = 0;
        }
        else if (f.min > 15 && f.min < 30) {
            f.min = 15;
        }
        else if (f.min > 30 && f.min < 45) {
            f.min = 30;
        }
        else if (f.min > 45) {
            f.min = 45;
        }
        int ans = 0;
        if (s.hr > f.hr || (s.hr == f.hr && s.min > f.min)) {
            if (s.min > 0) {
                ans += (60-s.min)/15;
                s.hr++;
            }
            ans += 4*(24-s.hr);
            s.hr = 0;
            s.min = 0;
        }
        ans += 4*(f.hr-s.hr);
        ans += (f.min-s.min)/15;
        return ans;
    }
}
class time {
    int hr;
    int min;
    public time(String s) {
        int t = s.indexOf(":");
        hr = Integer.parseInt(s.substring(0,t));
        min = Integer.parseInt(s.substring(t+1));
    }
}