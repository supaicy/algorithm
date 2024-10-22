package my.training.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    // 각 활동의 시작, 종료 시간을 포함한다.
    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        // 시작, 종료 시간을 설정
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(4, 6),
                new Activity(6, 7),
                new Activity(5, 9),
                new Activity(8, 9)
        };

        System.out.println("선택된 목록: ");
        selectActivities(activities);
    }

    public static void selectActivities(Activity[] activities) {
        // 종료 시간을 기준으로 오름차순 정렬
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        // 첫 번째 활동 선책(종료 시간이 가장 빠른 것들로)
        int n = activities.length;
        Activity lastSelected = activities[0];
        System.out.println("활동 (" + lastSelected.start + ", " + lastSelected.end + ")");

        // 종료 시간이 가장 이른것을 선택하고 다음 활동을 선택
        for(int i = 1; i < n; i++) {
            if(activities[i].start >= lastSelected.end) {
                lastSelected = activities[i];
                System.out.println("활동 (" + activities[i].start + ", " + activities[i].end + ")");
            }
        }
    }
}