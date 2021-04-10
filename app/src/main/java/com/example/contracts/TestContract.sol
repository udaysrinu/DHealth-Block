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
    
    event SinglePatientData(patientData []  EventData);
    event SingleDoctorData(patientData []  EventData);


    mapping (uint256 => bool) licenseExists;
    
    mapping(uint256 => patient) public pMap;
    mapping(uint256 => doctor) public dMap;
    
    
    mapping(uint256 => patientData []) public pDataList;
    mapping(uint256 => patientData []) public dDataList;


    patientData public  newData;

    function addPatientData(uint256 _id, string memory _doc_name, string memory _hospital, uint256 _license, uint256 _date, string memory _disease) public {

        newData.name_of_doc = _doc_name;
        newData.hospital = _hospital;
        newData.license = _license;
        newData.date = _date;
        newData.disease = _disease;
        
        pDataList[_id].push(newData);       //Accesing the patient history data list using _id -> Range of _id (0,2^256)
        dDataList[_license].push(newData);  //Accesing the doctors history data list using his license
    }
    
    function getPatientData(uint256 _id) public{
        emit SinglePatientData(pDataList[_id]);
    }
    function getDoctorData(uint256 _license){
        emit SingleDoctorData(dDataList[_license]);
    }

    patient newPatient;
    function createPatient(string memory _name,uint256 _adhar,address _account_address) public {
      
        newPatient = patient(pID,_name,_adhar,_account_address);
        pMap[pID]=newPatient;
        pID++;
        
    }
    
    function updatePatient(uint256 _id,string memory _name,uint256 _adhar,address _account_address) public {
        
        require(_id>pID,"Patient with given ID doesn't exist");
        
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
        
        
        dMap[_license].name = _name;
        dMap[_license].hospital = _hospital;
    }
    
    
    

}
