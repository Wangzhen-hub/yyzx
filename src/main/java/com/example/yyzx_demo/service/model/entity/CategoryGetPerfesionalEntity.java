package com.example.yyzx_demo.service.model.entity;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/21
 * Time: 14:17
 */
public class CategoryGetPerfesionalEntity {

    /**
     * success : true
     * message :
     * code : success
     * data : [{"id":1,"shortName":"键盘","firstCategoryId":1,"showIndex":1,"introduce":"键盘","image":"http://ali-files.yooshow.com/2017/06/20/decae9cd-76b8-4331-a574-b496eb5d38f9.png","searchKeys":"键盘","hide":0,"modifyDateStr":"2017-06-20 17:10:15"},{"id":31,"shortName":"弦乐器","firstCategoryId":1,"showIndex":1,"introduce":"弦乐器","image":"http://ali-files.yooshow.com/2017/05/12/056517d6-b326-4c3c-84d0-d9150db930d5.png","searchKeys":"弦乐器","hide":0,"modifyDateStr":"2017-06-22 15:34:22"},{"id":3,"shortName":"管乐器","firstCategoryId":1,"showIndex":3,"introduce":"管乐器","image":"http://ali-files.yooshow.com/2016/12/21/3f759824-265c-4458-90ed-044961bef6b3.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-20 14:29:33"},{"id":4,"shortName":"指挥","firstCategoryId":1,"showIndex":4,"introduce":"指挥","image":"http://ali-files.yooshow.com/2016/12/21/ada11602-b1c8-4921-a342-b65da008b2d4.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 10:14:07"},{"id":5,"shortName":"美声","firstCategoryId":1,"showIndex":5,"introduce":"美声","image":"http://ali-files.yooshow.com/2016/12/21/aa8754a6-2626-49ef-89ec-46d2940a9d56.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 10:14:23"},{"id":6,"shortName":"民族声乐","firstCategoryId":1,"showIndex":6,"introduce":"民族声乐","image":"http://ali-files.yooshow.com/2017/06/15/71aae880-cfaf-44b6-9a86-044d1d4b0ee7.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-15 17:34:19"},{"id":7,"shortName":"流行演唱","firstCategoryId":1,"showIndex":7,"introduce":"流行演唱","image":"http://ali-files.yooshow.com/2016/12/21/82f3dcf3-100c-434b-8674-516960aaefb2.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 10:14:42"},{"id":8,"shortName":"西洋打击乐","firstCategoryId":1,"showIndex":8,"introduce":"西洋打击乐","image":"http://ali-files.yooshow.com/2016/12/21/563999b9-36ba-4d48-a34d-a9a01313c914.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 10:14:53"},{"id":33,"shortName":"民族乐器","firstCategoryId":1,"showIndex":9,"introduce":"民族乐器","image":"http://ali-files.yooshow.com/2017/06/15/b1b71e50-6687-4362-b951-08e0a5cf2c5b.png","searchKeys":"民族乐器","hide":0,"modifyDateStr":"2017-06-15 17:37:24"},{"id":9,"shortName":"民族打击乐","firstCategoryId":1,"showIndex":10,"introduce":"民族打击乐","image":"http://ali-files.yooshow.com/2017/06/15/86fac64c-7f4c-40a1-81be-dcc6dab0708b.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-15 17:31:59"},{"id":10,"shortName":"器乐合奏","firstCategoryId":1,"showIndex":11,"introduce":"器乐合奏","image":"http://ali-files.yooshow.com/2016/12/21/b6fc3103-5e28-4700-b0cd-214cea67f0d5.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:23:30"},{"id":34,"shortName":"世界民族","firstCategoryId":1,"showIndex":12,"introduce":"世界民族","image":"http://ali-files.yooshow.com/2017/06/15/2fbe89dc-bec9-4bce-b8b1-67fd6a3c9deb.png","searchKeys":"世界民族","hide":0,"modifyDateStr":"2017-06-26 11:35:06"},{"id":11,"shortName":"合唱","firstCategoryId":1,"showIndex":13,"introduce":"合唱","image":"http://ali-files.yooshow.com/2016/12/23/ff4169c1-8c1e-4619-84c2-eb8e8dbb6ab2.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-20 14:30:09"},{"id":12,"shortName":"作曲技术","firstCategoryId":1,"showIndex":14,"introduce":"作曲技术","image":"http://ali-files.yooshow.com/2016/12/21/de0821d5-30db-4a8e-8de9-64df3c1bb52f.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:24:00"},{"id":13,"shortName":"视唱练耳","firstCategoryId":1,"showIndex":15,"introduce":"视唱练耳","image":"http://ali-files.yooshow.com/2016/12/21/43fcfac7-a9c9-4693-bd42-21067ece920a.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:24:06"},{"id":14,"shortName":"基本乐理","firstCategoryId":1,"showIndex":16,"introduce":"基本乐理","image":"http://ali-files.yooshow.com/2016/12/21/a0ae380f-426c-4cb4-8f25-391c57016763.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:24:15"},{"id":15,"shortName":"数字音乐","firstCategoryId":1,"showIndex":17,"introduce":"数字音乐","image":"http://ali-files.yooshow.com/2016/12/21/0af91cf6-1fc2-49e1-a644-71b3546ff77b.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:40:52"},{"id":16,"shortName":"音乐史","firstCategoryId":1,"showIndex":17,"introduce":"音乐史","image":"http://ali-files.yooshow.com/2016/12/21/872010ac-d801-440b-a40a-4c8b34401a2d.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:24:27"},{"id":17,"shortName":"民族音乐","firstCategoryId":1,"showIndex":18,"introduce":"民族音乐","image":"http://ali-files.yooshow.com/2017/06/15/510b2b3c-1d8e-4bb8-af02-83cc201fe75c.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-15 17:32:46"},{"id":18,"shortName":"世界音乐","firstCategoryId":1,"showIndex":19,"introduce":"世界音乐","image":"http://ali-files.yooshow.com/2016/12/21/9b160f73-0077-4966-9474-b9abfd144337.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:24:46"},{"id":19,"shortName":"音乐美学","firstCategoryId":1,"showIndex":20,"introduce":"音乐美学","image":"http://ali-files.yooshow.com/2016/12/21/267a8e4f-c8d0-4fc5-b77c-8b35cfade7d7.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:24:54"},{"id":20,"shortName":"音乐教育","firstCategoryId":1,"showIndex":21,"introduce":"音乐教育","image":"http://ali-files.yooshow.com/2016/12/21/156498bc-e26f-4962-bb5d-55ec883870fc.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:25:48"},{"id":21,"shortName":"音乐管理","firstCategoryId":1,"showIndex":22,"introduce":"音乐管理","image":"http://ali-files.yooshow.com/2016/12/21/56c7f725-377c-43ba-b3c7-eaf602a65d0b.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-26 11:33:46"},{"id":22,"shortName":"音乐欣赏","firstCategoryId":1,"showIndex":23,"introduce":"音乐欣赏","image":"http://ali-files.yooshow.com/2016/12/21/8a41120c-ccac-497e-bb26-59df7967eb73.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:26:02"},{"id":23,"shortName":"传统音乐","firstCategoryId":1,"showIndex":24,"introduce":"传统音乐","image":"http://ali-files.yooshow.com/2016/12/21/44c8a733-d15e-4d58-9477-f64140e5e3fb.png","searchKeys":"传统音乐","hide":0,"modifyDateStr":"2017-06-26 11:37:50"},{"id":35,"shortName":"音乐治疗","firstCategoryId":1,"showIndex":25,"introduce":"音乐治疗","image":"http://ali-files.yooshow.com/2017/06/15/2806cdd4-03ca-40c1-9bea-e85bf1d6084c.png","searchKeys":"音乐治疗","hide":0,"modifyDateStr":"2017-06-15 17:37:07"},{"id":25,"shortName":"音乐科技","firstCategoryId":1,"showIndex":26,"introduce":"音乐科技","image":"http://ali-files.yooshow.com/2016/12/21/99391e3b-3efe-4578-aab1-cc7099484882.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:26:58"},{"id":26,"shortName":"嗓音保健","firstCategoryId":1,"showIndex":27,"introduce":"嗓音保健","image":"http://ali-files.yooshow.com/2016/12/21/7f2b7d6f-f0ad-4400-93cf-0b7d132b107d.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:27:11"},{"id":24,"shortName":"学历教育","firstCategoryId":1,"showIndex":28,"introduce":"学历教育","image":"http://ali-files.yooshow.com/2016/12/21/95963204-f5ce-484c-a5e6-80321894d637.png","searchKeys":"","hide":0,"modifyDateStr":"2017-06-12 11:27:18"}]
     */

    private boolean success;
    private String message;
    private String code;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * shortName : 键盘
         * firstCategoryId : 1
         * showIndex : 1
         * introduce : 键盘
         * image : http://ali-files.yooshow.com/2017/06/20/decae9cd-76b8-4331-a574-b496eb5d38f9.png
         * searchKeys : 键盘
         * hide : 0
         * modifyDateStr : 2017-06-20 17:10:15
         */

        private int id;
        private String shortName;
        private int firstCategoryId;
        private int showIndex;
        private String introduce;
        private String image;
        private String searchKeys;
        private int hide;
        private String modifyDateStr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public int getFirstCategoryId() {
            return firstCategoryId;
        }

        public void setFirstCategoryId(int firstCategoryId) {
            this.firstCategoryId = firstCategoryId;
        }

        public int getShowIndex() {
            return showIndex;
        }

        public void setShowIndex(int showIndex) {
            this.showIndex = showIndex;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getSearchKeys() {
            return searchKeys;
        }

        public void setSearchKeys(String searchKeys) {
            this.searchKeys = searchKeys;
        }

        public int getHide() {
            return hide;
        }

        public void setHide(int hide) {
            this.hide = hide;
        }

        public String getModifyDateStr() {
            return modifyDateStr;
        }

        public void setModifyDateStr(String modifyDateStr) {
            this.modifyDateStr = modifyDateStr;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", shortName='" + shortName + '\'' +
                    ", firstCategoryId=" + firstCategoryId +
                    ", showIndex=" + showIndex +
                    ", introduce='" + introduce + '\'' +
                    ", image='" + image + '\'' +
                    ", searchKeys='" + searchKeys + '\'' +
                    ", hide=" + hide +
                    ", modifyDateStr='" + modifyDateStr + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CategoryGetPerfesionalEntity{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
