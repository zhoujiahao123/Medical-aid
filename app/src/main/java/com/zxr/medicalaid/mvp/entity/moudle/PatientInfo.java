package com.zxr.medicalaid.mvp.entity.moudle;

import java.util.List;

/**
 * Created by ASUS-NB on 2017/7/13.
 */

public class PatientInfo {
    /**
     * code : 200
     * message : OK#成功返回
     * body : {"page":{"totalNumber":1,"currentPage":1,"totalPage":1,"pageNumber":20,"dbIndex":0,"dbNumber":20},"list":[{"idString":"bd20722c436ba64d92b2930cc8def0cbf","nickName":"cb23919941f44caa88a903b3281076d5","phoneNumber":"5cf54b2aa42b733d00f181c4aa76ba20","type":"patient"}]}
     */

    private int code;
    private String message;
    /**
     * page : {"totalNumber":1,"currentPage":1,"totalPage":1,"pageNumber":20,"dbIndex":0,"dbNumber":20}
     * list : [{"idString":"bd20722c436ba64d92b2930cc8def0cbf","nickName":"cb23919941f44caa88a903b3281076d5","phoneNumber":"5cf54b2aa42b733d00f181c4aa76ba20","type":"patient"}]
     */

    private BodyBean body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * totalNumber : 1
         * currentPage : 1
         * totalPage : 1
         * pageNumber : 20
         * dbIndex : 0
         * dbNumber : 20
         */

        private PageBean page;
        /**
         * idString : bd20722c436ba64d92b2930cc8def0cbf
         * nickName : cb23919941f44caa88a903b3281076d5
         * phoneNumber : 5cf54b2aa42b733d00f181c4aa76ba20
         * type : patient
         */

        private List<ListBean> list;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class PageBean {
            private int totalNumber;
            private int currentPage;
            private int totalPage;
            private int pageNumber;
            private int dbIndex;
            private int dbNumber;

            public int getTotalNumber() {
                return totalNumber;
            }

            public void setTotalNumber(int totalNumber) {
                this.totalNumber = totalNumber;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public int getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(int pageNumber) {
                this.pageNumber = pageNumber;
            }

            public int getDbIndex() {
                return dbIndex;
            }

            public void setDbIndex(int dbIndex) {
                this.dbIndex = dbIndex;
            }

            public int getDbNumber() {
                return dbNumber;
            }

            public void setDbNumber(int dbNumber) {
                this.dbNumber = dbNumber;
            }
        }

        public static class ListBean {
            private String idString;
            private String nickName;
            private String phoneNumber;
            private String type;

            public String getIdString() {
                return idString;
            }

            public void setIdString(String idString) {
                this.idString = idString;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
