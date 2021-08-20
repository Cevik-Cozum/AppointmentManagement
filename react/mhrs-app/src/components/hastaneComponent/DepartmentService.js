import axios from "axios";


const USERS_REST_API_URL='http://localhost:8080/departmans';

class DepartmentService{

    async getAllDepartman(){
        const {data} = await axios.get(USERS_REST_API_URL);
        return data 

    }
}

const departmans={}

departmans.create=async (state) =>{

    const dataPost={
        name:state.doktorName,
    }

    
const urlPost=USERS_REST_API_URL+"/departmentcreate"

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



export default new DepartmentService();
