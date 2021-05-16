package DynamicProgram.dp0329;

import java.util.Arrays;

/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/29 18:14
 */
public class LC1405 {
    public String longestDiverseString(int a, int b, int c) {
        //myChar类型的数组,每个myChar类存放了字符和字符的个数,数组可以根据myChar.count排序
        myChar[] myChars = new myChar[]{
                new myChar('a', a),
                new myChar('b', b),
                new myChar('c', c)
        };
        StringBuilder sb = new StringBuilder();
        while(true){
            //根剧myChar.count排序, 剩余次数最多的为myChars[2].count
            Arrays.sort(myChars);
            //每次都是先放入剩余个数最多的字符,
            //如果之前的两个字符都是剩余个数最多的字符,放入剩余个数次多的字符,
            if(sb.length()>=2
                    &&sb.charAt(sb.length()-1)==myChars[2].ch
                    &&sb.charAt(sb.length()-2)==myChars[2].ch){
                //放入剩余个数次多的字符
                if(myChars[1].count-- > 0){
                    sb.append(myChars[1].ch);
                }else{
                    break;
                }
            }else{
                //先放入剩余个数次多的字符
                if(myChars[2].count-- > 0){
                    sb.append(myChars[2].ch);
                }else{
                    break;
                }
            }
        }
        return sb.toString();
    }

    /**
     * 自定义类,两个属性, 字符ch 字符ch对应的数量count
     * 实现了comparable接口,可以根据字符的数量排序
     */
    private class myChar implements Comparable{
        char ch;
        int count;

        public myChar(char ch, int count){
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Object o){
            myChar other = (myChar)o;
            return this.count-other.count;
        }
    }
}
