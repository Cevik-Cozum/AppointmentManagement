import axios from "axios";


const USERS_REST_API_URL='http://localhost:8080/citys';

class CityService{

    async getAllCity(){
        const {data} = await axios.get(USERS_REST_API_URL);
        return data 

    }
}

const citys={}

citys.create=async (state) =>{

    const dataPost={
        name:state.cityName,
    }

    
const urlPost=USERS_REST_API_URL+"/citycreate"

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



export default new CityService();
