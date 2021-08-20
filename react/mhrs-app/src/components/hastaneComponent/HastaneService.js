import axios from "axios";
import Axios from "axios";

const USERS_REST_API_URL='http://localhost:8080/hospitals';

class HastaneService{

    getAllHastane(){
        console.log();
        // return Axios.get(USERS_REST_API_URL).then(res => res.data.sort((a,b) => a.hospitalName.localeCompare(b.hospitalName)));
        return Axios.get(USERS_REST_API_URL).then(res => res.data);

    }
}

const hospitals={}

hospitals.create=async (state) =>{

    const dataPost={
        name:state.hospitalName,
        addressid:state.addressid,
    }

    
const urlPost=USERS_REST_API_URL+"/create"

const res=await axios.post(urlPost,dataPost)
.then(response =>{
    const data={success:true,message:response.data}
    return data;
})
.catch(error=>{
    const data={success:false,message:error.response.data}
    return data;
})
return res;

}



export default new HastaneService();
