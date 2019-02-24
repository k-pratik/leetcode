import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        System.out.println(insert(Arrays.asList(new Interval(1, 2), new Interval(3, 5),new Interval(6, 7)
        ,new Interval(8, 10),new Interval(12, 16)), new Interval(4, 8)));

//        System.out.println(insert(Arrays.asList(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5)));
//        System.out.println(insert(Arrays.asList(new Interval(1, 5)), new Interval(0, 3)));
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> tmp = new ArrayList<>(intervals);

        tmp.add(newInterval);
        tmp.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        List<Interval> res = new ArrayList<>();

        for (int i = 0; i < tmp.size(); i++) {

            if(res.size()==0){
                res.add(tmp.get(i));
                continue;
            }

            Interval comparedInterval = tmp.get(i);
            Interval currentInterval = res.get(res.size() - 1);

            Interval interval = new Interval();

            if (currentInterval.start <= comparedInterval.start && currentInterval.end >= comparedInterval.start) {
                //overlap
                interval.start = currentInterval.start;
                interval.end = Math.max(currentInterval.end, comparedInterval.end);
                res.set(res.size() - 1, interval);


            } else {

                res.add(comparedInterval);
            }


        }
        return res;

    }


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return start + " , " + end;
        }
    }

}
