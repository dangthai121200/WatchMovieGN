import axiosConfiguration from '../axios/axiosConfiguration';
import { API_MOVIE_GET_ALL } from '../constant/API';


export const getAllMovieRequest = async (page, size) => {
    const response = await axiosConfiguration.post(API_MOVIE_GET_ALL, {
        page: page,
        size: size
    });
    return response;
}