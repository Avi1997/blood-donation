import { Injectable } from '@angular/core';
import { State } from './State';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private gender: string[];
  private bloodGroup: string[];
  private timeSlot: string[];
  private states: State[];
  
  constructor() {
    this.gender = ["Male", "Female"];
    
    this.bloodGroup = ["A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-"];
    
    this.timeSlot = ["9 AM - 10 AM", "10 AM - 11 AM", "11 AM - 12 PM", "12 PM - 1 PM", "1 PM - 2 PM", "2 PM - 3 PM", "3 PM - 4 PM", "4 PM - 5 PM", "5 PM - 6 PM"];

    this.states = [
      {
        name: "Andaman and Nicobar Islands",
        cities: ["Nicobar", "North and Middle Andaman", "South Andaman"]
      },
      {
        name: "Andhra Pradesh",
        cities: ["Anantapur", "Chittoor", "East Godavari", "Guntur", "Kadapa", "Krishna", "Kurnool", "Nellore", "Prakasam", "Srikakulam", "Visakhapatnam", "Vizianagaram", "West Godavari"]
      },
      {
        name: "Arunachal Pradesh",
        cities: ["Tawang", "West Kameng", "East Kameng", "Pakke-Kessang", "Papum Pare", "Kurung Kumey", "Kra Daadi", "Lower Subansiri", "Upper Subansiri", "West Siang", "Shi-Yomi", "East Siang", "Siang", "Upper Siang", "Lower Siang", "Lepa-Rada", "Lower Dibang Valley", "Upper Dibang Valley", "Anjaw", "Lohit", "Namsai", "Changlang", "Tirap", "Longding", "Kamle"]
      },
      {
        name: "Assam",
        cities: ["Baksa", "Barpeta", "Biswanath", "Bongaigaon", "Cachar", "Charaideo", "Chirang", "Darrang", "Dhemaji", "Dhubri", "Dibrugarh", "Dima Hasao", "Goalpara", "Golaghat", "Hailakandi", "Hojai", "Jorhat", "Kamrup Metropolitan", "Kamrup", "Karbi Anglong", "Karimganj", "Kokrajhar", "Lakhimpur", "Majuli", "Morigaon", "Nagaon", "Nalbari", "Sivasagar", "Sonitpur", "South Salmara-Mankachar", "Tinsukia", "Udalguri", "West Karbi Anglong"]
      },
      {
        name: "Bihar",
        cities: ["Araria", "Arwal", "Aurangabad", "Banka", "Begusarai", "Bhagalpur", "Bhojpur", "Buxar", "Darbhanga", "East Champaran", "Gaya", "Gopalganj", "Jamui", "Jehanabad", "Khagaria", "Kishanganj", "Kaimur", "Katihar", "Lakhisarai", "Madhubani", "Munger", "Madhepura", "Muzaffarpur", "Nalanda", "Nawada", "Patna", "Purnia", "Rohtas", "Saharsa", "Samastipur", "Sheohar", "Sheikhpura", "Saran", "Sitamarhi", "Supaul", "Siwan", "Vaishali", "West Champaran"]
      },
      {
        name: "Chandigarh",
        cities: ["Chandigarh"]
      },
      {
        name: "Chhattisgarh",
        cities: ["Balod", "Baloda Bazar", "Balrampur", "Bastar", "Bemetara", "Bijapur", "Bilaspur", "Dantewada", "Dhamtari", "Durg", "Gariaband	", "Janjgir-Champa", "Jashpur", "Kabirdham", "Kanker", "Kondagaon", "Korba", "Koriya", "Mahasamund", "Mungeli", "Narayanpur", "Raigarh", "Raipur", "Rajnandgaon", "Sukma", "Surajpur", "Surguja"]
      },
      {
        name: "Dadra and Nagar Haveli",
        cities: ["Amli", "Dadra", "Nagar Haveli", "Silvassa"]
      },
      {
        name: "Daman and Diu",
        cities: ["Daman", "Diu"]
      },
      {
        name: "Delhi",
        cities: ["New Delhi", "Alipur", "Kanjhawala", "Rajouri Garden", "Dwarka", "Saket", "Defence Colony", "Daryaganj", "Nand Nagri", "Shahdara", "Preet Vihar"]
      },
      {
        name: "Goa",
        cities: ["North Goa", "South Goa"]
      },
      {
        name: "Gujarat",
        cities: ["Ahmedabad", "Vadodara", "Anand", "Chhota Udaipur", "Dahod", "Kheda", "Mahisagar", "Panchmahal", "Gandhinagar", "Aravalli", "Banaskantha", "Mehsana", "Patan", "Sabarkantha", "Rajkot", "Amreli", "Bhavnagar", "Botad", "Devbhoomi Dwarka", "Gir Somnath", "Jamnagar", "Junagadh", "Morbi", "Porbandar", "Surendranagar", "Kachchh", "Surat", "Bharuch", "Dang", "Narmada", "Navsari", "Tapi", "Valsad"]
      },
      {
        name: "Haryana",
        cities: ["Ambala", "Bhiwani", "Charkhi Dadri", "Faridabad", "Fatehabad", "Gurugram", "Hisar", "Jhajjar", "Jind", "Kaithal", "Karnal", "Kurukshetra", "Mahendragarh", "Nuh", "Palwal", "Panchkula", "Panipat", "Rewari", "Rohtak", "Sirsa", "Sonipat", "Yamunanagar"]
      },
      {
        name: "Himachal Pradesh",
        cities: ["Bilaspur", "Chamba", "Hamirpur", "Kangra", "Kinnaur", "Kullu", "Lahaul and Spiti", "Mandi", "Shimla", "Sirmaur", "Solan", "Una"]
      },
      {
        name: "Jammu and Kashmir",
        cities: ["Doda", "Jammu", "Kathua", "Kishtwar", "Poonch", "Rajouri", "Ramban", "Reasi", "Samba", "Udhampur", "Anantnag", "Bandipora", "Baramulla", "Budgam", "Ganderbal", "Kulgam", "Kupwara", "Pulwama", "Shopian", "Srinagar"]
      },
      {
        name: "Jharkhand",
        cities: ["Garhwa", "Palamu", "Latehar", "Chatra", "Hazaribagh", "Koderma", "Giridih", "Ramgarh", "Bokaro", "Dhanbad", "Gumla", "Lohardaga", "Simdega", "Ranchi", "Khunti", "West Singhbhum", "Saraikela Kharsawan", "East Singhbhum", "Jamtara", "Deoghar", "Dumka", "Pakur", "Godda", "Sahebganj"]
      },
      {
        name: "Karnataka",
        cities: ["Bagalkot", "Bengaluru Urban", "Bengaluru Rural", "Belagavi", "Ballari", "Bidar", "Vijayapur", "Chamarajanagar", "Chikballapur", "Chikkamagaluru", "Chitradurga", "Dakshina Kannada", "Davanagere", "Dharwad", "Gadag", "Kalaburagi", "Hassan", "Haveri", "Kodagu", "Kolar", "Koppal", "Mandya", "Mysuru", "Raichur", "Ramanagara", "Shivamogga", "Tumakuru", "Udupi", "Uttara Kannada", "Yadgir"]
      },
      {
        name: "Kerala",
        cities: ["Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod", "Kollam", "Kottayam", "Kozhikode", "Malappuram", "Palakkad", "Pathanamthitta", "Thiruvananthapuram", "Thrissur", "Wayanad"]
      },
      {
        name: "Ladakh",
        cities: ["Kargil", "Leh"]
      },
      {
        name: "Lakshadweep",
        cities: ["Agatti Island", "Amini", "Andrott", "Bangaram Atoll", "Bitra", "Chetlat Island", "Kadmat Island", "Kalpeni", "Kavaratti", "Kiltan", "Minicoy"]
      },
      {
        name: "Madhya Pradesh",
        cities: ["Bhopal", "Raisen", "Rajgarh", "Sehore", "Vidisha", "Morena", "Sheopur", "Bhind", "Gwalior", "Ashoknagar", "Shivpuri", "Datia", "Guna", "Alirajpur", "Barwani", "Burhanpur", "Indore", "Dhar", "Jhabua", "Khandwa", "Khargone", "Balaghat", "Chhindwara", "Jabalpur", "Katni", "Mandla", "Narsinghpur", "Seoni", "Dindori", "Betul", "Harda", "Hoshangabad", "Rewa", "Satna", "Sidhi", "Singrauli", "Chhatarpur", "Damoh", "Panna", "Sagar", "Tikamgarh", "Niwari", "Anuppur", "Shahdol", "Umaria", "Agar Malwa", "Dewas", "Mandsaur", "Neemuch", "Ratlam", "Shajapur", "Ujjain"]
      },
      {
        name: "Maharashtra",
        cities: ["Akola", "Amravati", "Buldana", "Yavatmal", "Washim", "Aurangabad", "Beed", "Jalna", "Osmanabad", "Nanded", "Latur", "Parbhani", "Hingoli", "Mumbai City", "Mumbai Suburban", "Thane", "Palghar", "Raigad", "Ratnagiri", "Sindhudurg", "Bhandara", "Chandrapur", "Gadchiroli", "Gondia", "Nagpur", "Wardha", "Ahmednagar", "Dhule", "Jalgaon", "Nandurbar", "Nashik", "Kolhapur", "Pune", "Sangli", "Satara", "Solapur"]
      },
      {
        name: "Manipur",
        cities: ["Bishnupur", "Thoubal", "Imphal East", "Imphal West", "Senapati", "Ukhrul", "Chandel", "Churachandpur", "Tamenglong", "Jiribam", "Kangpokpi (Sadar Hills)", "Kakching", "Tengnoupal", "Kamjong", "Noney", "Pherzawl"]
      },
      {
        name: "Meghalaya",
        cities: ["East Garo Hills (Williamnagar)", "East Jaintia Hills (Khliehriat)", "East Khasi Hills (Shillong)", "North Garo Hills (Resubelpara)", "Ri Bhoi (Nongpoh)", "South Garo Hills (Baghmara)", "South West Garo Hills (Ampati)", "South West Khasi Hills (Mawkyrwat)", "West Garo Hills (Tura)", "West Jaintia Hills (Jowai)", "West Khasi Hills (Nongstoin)"]
      },
      {
        name: "Mizoram",
        cities: ["Aizawl", "Champhai", "Kolasib", "Lawngtlai", "Lunglei", "Mamit", "Saiha", "Serchhip"]
      },
      {
        name: "Nagaland",
        cities: ["Dimapur", "Kiphire", "Kohima", "Longleng", "Mokokchung", "Mon", "Noklak", "Peren", "Phek", "Tuensang", "Wokha", "Zunheboto"]
      },
      {
        name: "Odisha",
        cities: ["Angul", "Boudh (Baudh)", "Balangir", "Bargarh", "Balasore (Baleswar)", "Bhadrak", "Cuttack", "Deogarh (Debagarh)", "Dhenkanal", "Ganjam", "Gajapati", "Jharsuguda", "Jajpur", "Jagatsinghapur", "Khordha", "Keonjhar (Kendujhar)", "Kalahandi", "Kandhamal", "Koraput", "Kendrapara", "Malkangiri", "Mayurbhanj", "Nabarangpur", "Nuapada", "Nayagarh", "Puri", "Rayagada", "Sambalpur", "Subarnapur (Sonepur)", "Sundargarh"]
      },
      {
        name: "Puducherry",
        cities: ["Karaikal", "Mahé", "Pondicherry", "Yanam"]
      },
      {
        name: "Punjab",
        cities: ["Amritsar", "Barnala", "Bathinda", "Faridkot", "Fatehgarh Sahib", "Firozpur", "Fazilka", "Gurdaspur", "Hoshiarpur", "Jalandhar", "Kapurthala", "Ludhiana", "Mansa", "Moga", "Sri Muktsar Sahib", "Pathankot", "Patiala", "Rupnagar", "Sahibzada Ajit Singh Nagar", "Sangrur", "Shahid Bhagat Singh Nagar", "Taran Taran"]
      },
      {
        name: "Rajasthan",
        cities: ["Ajmer", "Alwar", "Banswara", "Baran", "Barmer", "Bharatpur", "Bhilwara", "Bikaner", "Bundi", "Chittorgarh", "Churu", "Dausa", "Dholpur", "Dungarpur", "Hanumangarh", "Jaipur", "Jaisalmer", "Jalor", "Jhalawar", "Jhunjhunu", "Jodhpur", "Karauli", "Kota", "Nagaur", "Pali", "Pratapgarh", "Rajsamand", "Sawai Madhopur", "Sikar", "Sirohi", "Sri Ganganagar", "Tonk", "Udaipur"]
      },
      {
        name: "Sikkim",
        cities: ["Chungthang", "Gangtok", "Gyalshing", "Mangan", "Namchi", "Pakyong", "Ravong", "Rongli", "Soreng"]
      },
      {
        name: "Tamil Nadu",
        cities: ["Ariyalur", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode", "Kanchipuram", "Kanniyakumari", "Karur", "Krishnagiri", "Madurai", "Nagapattinam", "Namakkal", "The Nilgiris", "Perambalur", "Pudukkottai", "Ramanathapuram", "Salem", "Sivaganga", "Thanjavur", "Theni", "Thoothukudi", "Tiruchirappalli", "Tirunelveli", "Tiruppur", "Tiruvallur", "Tiruvannamalai", "Tiruvarur", "Vellore", "Viluppuram", "Virudhunagar"]
      },
      {
        name: "Telangana",
        cities: ["Adilabad", "Bhadradri Kothagudem", "Hyderabad", "Jagitial", "Jangaon", "Jayashankar Bhupalapally", "Jogulamba Gadwal", "Kamareddy", "Karimnagar", "Khammam", "Komaram Bheem", "Mahabubabad", "Mahabubnagar", "Mancherial district", "Medak", "Medchal–Malkajgiri", "Mulugu", "Nagarkurnool", "Narayanpet", "Nalgonda", "Nirmal", "Nizamabad", "Peddapalli", "Rajanna Sircilla", "Ranga Reddy", "Sangareddy", "Siddipet", "Suryapet", "Vikarabad", "Wanaparthy", "Warangal Rural", "Warangal Urban", "Yadadri Bhuvanagiri"]
      },
      {
        name: "Tripura",
        cities: ["Agartala", "Amarpur", "Amarpur", "Dharmanagar", "Kailasahar", "Kamalpur", "Khowai", "Kumarghat", "Ranirbazar", "Sabroom", "Sonamura", "Teliamura", "Udaipur", "Bishalgarh", "Santirbazar", "Ambassa", "Jirania", "Mohanpur", "Melaghar", "Panisagar"]
      },
      {
        name: "Uttar Pradesh",
        cities: ["Agra", "Aligarh", "Allahabad", "Ambedkar Nagar", "Amethi", "Amroha", "Auraiya", "Azamgarh", "Badaun", "Bahraich", "Ballia", "Balrampur", "Banda District", "Barabanki", "Bareilly", "Basti", "Bijnor", "Bulandshahr", "Chandauli(Varanasi Dehat)", "Chitrakoot", "Deoria", "Etah", "Etawah", "Faizabad", "Farrukhabad", "Fatehpur", "Firozabad", "Gautam Buddha Nagar", "Ghaziabad", "Ghazipur", "Gonda", "Gorakhpur", "Hamirpur", "Hapur District", "Hardoi", "Hathras", "Jaunpur District", "Jhansi", "Kannauj", "Kanpur Dehat", "Kanpur Nagar", "Kasganj", "Kaushambi", "Kushinagar", "Lakhimpur Kheri", "Lalitpur", "Lucknow", "Maharajganj", "Mahoba", "Mainpuri", "Mathura", "Mau", "Meerut", "Mirzapur", "Moradabad", "Muzaffarnagar", "Pilibhit", "Pratapgarh", "Rae Bareli", "Rampur", "Saharanpur", "Sant Kabir Nagar", "Sant Ravidas Nagar", "Sambhal", "Shahjahanpur", "Shamli", "Shravasti", "Siddharthnagar", "Sitapur", "Sonbhadra", "Sultanpur", "Unnao", "Varanasi (Kashi)"]
      },
      {
        name: "Uttarakhand",
        cities: ["Almora", "Bageshwar", "Chamoli", "Champawat", "Dehradun", "Haridwar", "Nainital", "Pauri Garhwal", "Pithoragarh", "Rudraprayag", "Tehri Garhwal", "Udham Singh Nagar", "Uttarkashi"]
      },
      {
        name: "West Bengal",
        cities: ["Alipurduar", "Bankura", "Birbhum", "Cooch Behar", "Dakshin Dinajpur", "Darjeeling", "Hooghly", "Howrah", "Jalpaiguri", "Jhargram", "Kalimpong", "Kolkata", "Malda", "Murshidabad", "Nadia", "North 24 Parganas", "Paschim Bardhaman", "Paschim Medinipur", "Purba Bardhaman", "Purba Medinipur", "Purulia", "South 24 Parganas", "Uttar Dinajpur"]
      }
    ];
  }

  getGenders() {
    return this.gender;
  }

  getBloodGroups() {
    return this.bloodGroup;
  }

  getTimeSlot() {
    return this.timeSlot;
  }

  getStates() {
    return this.states;
  }

  getCities(selectedState: string) {
    let cityArray: string[];
    cityArray = this.states.find(state => state.name == selectedState).cities;
    return cityArray;
  }
}
