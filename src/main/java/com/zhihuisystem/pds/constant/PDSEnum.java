package com.zhihuisystem.pds.constant;

/**
 * <p> </p>
 *
 * @className PDSEnum
 * @Description TODO
 * @Author liuqing
 * @Date 2020/6/11 23:43
 * @Version 1.0.0
 * @see
 */
public interface PDSEnum {
    enum PDSSex {
        MAN(0, "男"),
        WOMAN(1, "女");
        private final Integer value;
        private final String desc;
        PDSSex(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        public Integer getValue() {
            return this.value;
        }
        public String getDesc() {
            return this.desc;
        }
    }

}
