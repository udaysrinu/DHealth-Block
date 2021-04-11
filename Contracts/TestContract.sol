// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.3;


contract D_Health_Block{
    
    uint256 pID=0;
    
    struct patient {
        uint256 id;
        string name;
        uint256 adhar;
        address account_address;
        
    }
    struct patientData{
        uint256 patient_id;
        string name_of_doc;
        string hospital;
        uint256 license;
        uint256 date;
        string disease;
    }
    
    struct doctor{
        uint256 license;
        string name;
        string hospital;
        
    }
    

    
    
    mapping (uint256 => bool) licenseExists;
    mapping(uint256 => bool) adharExists;
    
    mapping(uint256 => patient) public pMap;
    mapping(uint256 => doctor) public dMap;
    
    
    mapping(uint256 => patientData []) public pDataList;
    mapping(uint256 => patientData []) public dDataList;

    
    patientData public  newData;
    
    function addPatientData(uint256 _id, string memory _doc_name, string memory _hospital, uint256 _license, uint256 _date, string memory _disease) public {
        
        require(_id<pID, "This _id does not exist");
        newData.patient_id = _id;
        newData.name_of_doc = _doc_name;
        newData.hospital = _hospital;
        newData.license = _license;
        newData.date = _date;
        newData.disease = _disease;
        
        pDataList[_id].push(newData);       //Accesing the patient history data list using _id -> Range of _id (0,2^256)
        dDataList[_license].push(newData);  //Accesing the doctors history data list using his license
        licenseExists[_license]=true;       //Adding the licenseExists=true even if the doctor has not registered.
    }
    
    //returns user_id, doctor_name, his_licence,date,disease
    function getPatientData(uint256 _id) public view returns(uint256 [] memory, string [] memory,  uint256 [] memory, uint256 [] memory, string [] memory){
        //emit SinglePatientData(pDataList[_id]);
        require(_id<pID, "This _id does not exist");
        uint256 [] memory id_ = new uint256[](pDataList[_id].length);
        string [] memory doc_n = new string[](pDataList[_id].length);

        uint256 [] memory lic = new uint256[](pDataList[_id].length);
        uint256 [] memory d = new uint256[](pDataList[_id].length);
        string [] memory dis = new string[](pDataList[_id].length);
        
        
        for(uint i=0; i<pDataList[_id].length; i++){
                patientData memory temp = pDataList[_id][i];
                id_[i] = temp.patient_id;
               doc_n[i] = temp.name_of_doc;
           
               lic[i] = temp.license;
               d[i] = temp.date;
               dis[i] = temp.disease;
        }
        return (id_, doc_n,lic,d,dis);
    }
    
    //returns user_id, doctor_name, his_licence,date,disease
    function getDoctorData(uint256 _license) public  view returns(uint256 [] memory, string [] memory,  uint256 [] memory, uint256 [] memory, string [] memory){
        //emit SingleDoctorData(dDataList[_license]);
        require(licenseExists[_license]==true, "No data exists for this");
        uint256 [] memory id_ = new uint256[](dDataList[_license].length);
        string [] memory doc_n = new string[](dDataList[_license].length);
     
        uint256 [] memory lic = new uint256[](dDataList[_license].length);
        uint256 [] memory d = new uint256[](dDataList[_license].length);
        string [] memory dis = new string[](dDataList[_license].length);
        
        
        for(uint i=0; i<dDataList[_license].length; i++){
                patientData storage temp = dDataList[_license][i];
                id_[i] = temp.patient_id;
               doc_n[i] = temp.name_of_doc;
              
               lic[i] = temp.license;
               d[i] = temp.date;
               dis[i] = temp.disease;
        }
        return (id_, doc_n,lic,d,dis);

    }
    
    patient newPatient;
    
    
    function createPatient(string memory _name,uint256 _adhar,address _account_address) public {
      
        require(adharExists[_adhar]==false,"This adhar is already registered");
        newPatient = patient(pID,_name,_adhar,_account_address);
        pMap[pID]=newPatient;
        pID++;
        adharExists[_adhar]==true;
        
    }
    
    function updatePatient(uint256 _id,string memory _name,uint256 _adhar,address _account_address) public {
        
        require(_id<pID,"Patient with given ID doesn't exist");
        
        pMap[_id].name=_name;
        pMap[_id].adhar=_adhar;
        pMap[_id].account_address=_account_address;
    }
    
    doctor newDoctor;
    function createDoctor(uint256 _license,string memory _name,string memory _hospital) public {
        
        require(licenseExists[_license]==false, "You have already registered");
        newDoctor = doctor(_license,_name,_hospital);
        dMap[_license]=newDoctor;
        licenseExists[_license]=true;
    }
    
    function updateDoctor(uint256 _license,string memory _name,string memory _hospital) public {
        
        require(licenseExists[_license]==true, "You have to register first");
        dMap[_license].name = _name;
        dMap[_license].hospital = _hospital;
    }
    
    
    

}