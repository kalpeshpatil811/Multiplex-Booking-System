package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowAlreadyExistException;
import com.multiplex.exception.ShowNotFoundException;

/**************************
 * Shows Service Interface
 *
 * Created By: Laxman Adkune
 * Date:19/03/2022
 ***************************/

public interface IShowsService {

	public List<Shows> getShows();

	public Shows addShows(Shows addshow) throws ShowAlreadyExistException;

	public Shows updateShows(Shows updateshow);

	public void deleteShowsById(Integer showid) throws ShowNotFoundException;

	public Shows getShowById(Integer showid) throws ShowNotFoundException;

}
