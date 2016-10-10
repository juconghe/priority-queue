package structures;

import java.util.Comparator;
public class MinIntegerComparator implements Comparator<Integer> {
	
		public int compare(Integer arg0, Integer arg1)
		{
			if(arg0>arg1) return-1;
			if(arg0 < arg1) return 1;
			return arg0.compareTo(arg1);
	}

}
