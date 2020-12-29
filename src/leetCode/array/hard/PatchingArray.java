package leetCode.array.hard;

/**
 * @author liyu
 * date 2020/12/29 8:55
 * description ��Ҫ��������
 * ����һ������������������� nums����һ��������?n ����?[1, n]?������ѡȡ��������ֲ��䵽?nums?�У�
 * ʹ��?[1, n]?�����ڵ��κ����ֶ�������?nums?��ĳ�������ֵĺ�����ʾ��
 * �������������Ҫ���������Ҫ��������ָ�����
 * ʾ��?1:
 * ����: nums = [1,3], n = 6
 * ���: 1
 * ����:
 * ���� nums?�����е����?[1], [3], [1,3]�����Եó�?1, 3, 4��
 * ����������ǽ�?2?���ӵ�?nums �У�?��ϱ�Ϊ: [1], [2], [3], [1,3], [2,3], [1,2,3]��
 * ��Ϳ��Ա�ʾ����?1, 2, 3, 4, 5, 6���ܹ�����?[1, 6]?���������е�����
 * ��������������Ҫ����һ�����֡�
 * ʾ�� 2:
 * ����: nums = [1,5,10], n = 20
 * ���: 2
 * ����: ������Ҫ����?[2, 4]��
 * ʾ��?3:
 * ����: nums = [1,2,2], n = 5
 * ���: 0
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/patching-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PatchingArray {
    /**
     * ����һ��̰���㷨
     * ���������� x��������� [1,x?1] �ڵ��������ֶ��Ѿ������ǣ��� x �������У������� [1,2x?1] �ڵ���������Ҳ�������ǡ�֤�����¡�
     * �������� 1��y<x��y �Ѿ������ǣ�x �������У���� y+x Ҳ�����ǣ����� [x+1,2x?1]�������� [1,x-1]�ڵ�ÿ�����ּ��� x ֮��õ������䣩�ڵ���������Ҳ�����ǣ�
     * �ɴ˿ɵ����� [1,2x-1]�ڵ��������ֶ������ǡ�
     * �������� x ȱʧ����������Ҫ�������в���һ��С�ڻ���� x ���������ܸ��ǵ� x�������޷����ǵ� x��
     * ������� [1,x?1] �ڵ��������ֶ��Ѿ������ǣ����̰�ĵĽǶȿ��ǣ����� x ֮�󼴿ɸ��ǵ� x�������㲹������ָ������١�
     * �ڲ��� x ֮������ [1,2x?1] �ڵ��������ֶ������ǣ���һ��ȱʧ������һ������С�� 2x��
     * �ɴ˿������һ��̰�ĵķ�����ÿ���ҵ�δ������ nums ���ǵ���С������ x���������в��� x��Ȼ��Ѱ����һ��δ�����ǵ���С���������ظ���������ֱ������ [1,n] �е��������ֶ������ǡ�
     * ����ʵ�ַ��棬�κ�ʱ��Ӧ�������� [1,x?1] �ڵ��������ֶ������ǡ��� x �ĳ�ʼֵΪ 1�������±� index �ĳ�ʼֵΪ 0�����ʼ״̬������ [1,x?1] Ϊ�����䣬���������ڵ��������ֶ������ǡ�
     * �������²�����
     * ��� index ������ nums ���±귶Χ���� nums[index]��x���� nums[index] ��ֵ�Ӹ� x������ index ��ֵ�� 1��
     * �����ǵ������ [1,x?1] ��չ�� [1,x+nums[index]?1]���� x ��ֵ�����Ժ󣬱����ǵ�����Ϊ [1,x?1]��
     * ����x û�б����ǣ������Ҫ�������в��� x��Ȼ�� x ��ֵ���� 2��
     * �������в��� x ֮�󣬱����ǵ������ [1,x?1] ��չ�� [1,2x?1]���� x ��ֵ�����Ժ󣬱����ǵ�����Ϊ [1,x?1]��
     * �ظ�����������ֱ�� x ��ֵ���� n��
     * �����κ�ʱ���������� [1,x?1] �ڵ��������ֶ������ǣ���������������Ա�֤���� [1,n] �ڵ��������ֶ������ǡ�
     * ��������������ֻ�� x ��������ʱ���������в��� x�����
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}