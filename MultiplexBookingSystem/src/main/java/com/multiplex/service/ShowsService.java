package com.multiplex.service;

import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowAlreadyExistException;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.repository.ShowsDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**************************
 * Shows Service Class
 *
 * Created By: Laxman Adkune
 * Date:19/03/2022
 ***************************/

@Service
public class ShowsService implements IShowsService {

	@Autowired
	ShowsDao showsdao;

	// get
	@Override
	public List<Shows> getShows() {
		return showsdao.findAll();
	}

	// searchById
	@Override
	public Shows getShowById(Integer showid) throws ShowNotFoundException {
		try {
			return showsdao.findById(showid).get();
		} catch (Exception e) {
			throw new ShowNotFoundException("Show not found...");
		}
	}

	// post
	@Override
	public Shows addShows(Shows addshow) throws ShowAlreadyExistException {
		List<Shows> list = showsdao.findAll();
		for (Shows s : list) {
			if (s.getShowId() == addshow.getShowId()) {
				throw new ShowAlreadyExistException("Show already exists...");
			}
		}
		return showsdao.save(addshow);
	}

	// put
	@Override
	public Shows updateShows(Shows updateshow) {
		showsdao.save(updateshow);
		return updateshow;
	}

	// delete
	@Override
	public void deleteShowsById(Integer showid) throws ShowNotFoundException {
		try {
			showsdao.deleteById(showid);
		} catch (Exception e) {
			throw new ShowNotFoundException("Show not found...");
		}
	}
}
