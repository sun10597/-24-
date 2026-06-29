import { useState } from "react";

const TimeExam = () => {
    const [time, setTime] = useState(0);

    const upTime = () => {
        if(time>=23){
            setTime(0)
        }else{
            setTime(time + 1);
        }
    };

    const downTime = () => {
    if(time<=0){
            setTime(23)
        }else{
            setTime(time - 1);
        }
    };

    return(
        <div>
            <span>시간 : {time}시</span>
            <br></br>
            <button onClick={upTime}>up</button>
            <button onClick={downTime}>down</button>
           
        </div>
    )
}
export default TimeExam;