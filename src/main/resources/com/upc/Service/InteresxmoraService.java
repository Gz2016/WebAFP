package com.upc.Service;

import com.upc.Entities.Interesxmora;

public interface InteresxmoraService {
	//BD:
	Iterable<Interesxmora> listartodos();
	Interesxmora crear (Interesxmora i);
	Interesxmora getInteresxmoraporid(int cinteresxmora);
}
