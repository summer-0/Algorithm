package day09;

public class InsertSort {
/**
 * 直接插入排序：边遍历边排序    (空间复杂度较大，内存操作频繁)
 * {9,3,2,6,10,44,83,28,5,1,0,36}
 * 9
 * 3,9
 * 2,3,9
 * 2,3,6,9
 * 2,3,6,9,10
 * .....
 * 
 * @param args
 */
	public static void main(String[] args) {
        int[] array = {9,3,2,6,10,44,83,28,5,1,0,36};
        
        for(int i=1; i<array.length; i++){
        	int temp = array[i];
        	int j;
        	for(j=i-1; j>=0; j--){
        		if(array[j] > temp){
        		   array[j+1] = array[j];	 //从后面开始一个一个往后挪(比前面开始比较好)
        		}else{
        			break;
        		}
        	}
        	array[j+1] = temp;//  这里的j+1 是因为  上面j-- 循环不成立而退出的
        }
        
        System.out.println("排序后：");
        for (int i : array) {
			System.out.print(i+" ");
		}
       
	}

}
