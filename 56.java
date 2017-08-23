/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0){
            return res;
        }
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start > end){
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
            else{
                end = Math.max(end, intervals.get(i).end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}