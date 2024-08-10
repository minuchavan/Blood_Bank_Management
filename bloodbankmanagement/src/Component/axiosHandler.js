import axios from "axios";

const http=axios.create({
    baseURL:"http://localhost:8082/api",
    headers:{
        "Content-Type":"application/json"
    },
    withCredentials:true,
    methods: ["GET", "POST", "PUT", "DELETE"],
})

export default http;