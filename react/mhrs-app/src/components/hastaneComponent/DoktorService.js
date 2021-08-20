import axios from "axios";

const USERS_REST_API_URL='http://localhost:8080/doctors';

class DoktorService{

    getAllDoktor(){
        console.log();
        // return Axios.get(USERS_REST_API_URL).then(res => res.data.sort((a,b) => a.hospitalName.localeCompare(b.hospitalName)));
        return axios.get(USERS_REST_API_URL).then(res => res.data);

    }
}

const doktors={}

doktors.create=async (state) =>{

    const dataPost={
        name:state.doktorName,
    }

    
const urlPost=USERS_REST_API_URL+"/doktorcreate"

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



export default new DoktorService();
