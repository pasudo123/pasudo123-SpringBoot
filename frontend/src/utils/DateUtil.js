
const utils = {

    parseObjectToyyyyMMdd_hhmmss(date){

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

    parseStringToyyyyMMdd_hhmmss(date){

        // 2019-07-17 22:52:10
        let front = date.split(" ")[0];
        let back = date.split(" ")[1];

        let year = front.split("-")[0] + "년 ";
        let month = front.split("-")[1] + "월 ";
        let day = front.split("-")[2] + "일";

        let hour = back.split(":")[0] + "시 ";
        let minute = back.split(":")[1] + "분 ";
        let second = back.split(":")[2] + "초";

        return (year + month + day + " " + hour + minute + second);
    },

    parseTohhmmss(date){
        return '';
    }

};

export default utils
