import axios from "axios"
const API_URL = "/api"
class BookingDataService {
    retrieveAllBooking() {
        return axios.get(`${API_URL}/booking`)
    }
}
export default new BookingDataService()