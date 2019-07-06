
const CUSTOM_DATE_UTIL = {

    parseToyyyyMMdd_hhmmss(date){

        let dateString = String(date.year + "년 " + date.monthValue + "월 " + date.dayOfMonth + "일");
        let timeString = '';

        if (date.hour >= 13){
            let hour = "오후 " + (date.hour - 12) + "시";
            let minute = date.minute + "분";
            timeString = hour + " " + minute;
        } else{
            let hour = "오전 " + (date.hour) + "시";
            let minute = date.minute + "분";
            timeString = hour + " " + minute;
        }

        return (dateString + " " + timeString);
    },

    parseToyyyyMMdd(date){
        return '';
    },

    parseTohhmmss(date){
        return '';
    }

};

export default CUSTOM_DATE_UTIL