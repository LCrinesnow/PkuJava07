public class Solution {
    public boolean canWinNim(int n) {
        
        //�����ʼ������������ʯͷ���ߵ��Լ�ʱ��ֻʣ��1��2��3��ʯͷ����ô�Լ��϶���Ӯ
        //Ҳ����ֻҪ����4N��ʱ��Ϳ϶�Ϊ��
        /*
        if (n == 1 || n == 2 || n == 3)
          return true;
        else if()
        {
            
        }
        else
         return false;
    }*/
    return (n%4 == 0)?false:true;
   }
}
}