/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.controller;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sample.data.jpa.domain.projection.HotelProjection;
import sample.data.jpa.service.HotelService;

@RestController
@RequestMapping("/hotels")
@Slf4j
public class HotelController {

	private final HotelService hotelService;

	public HotelController(final HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@GetMapping
	@ResponseBody
	@Transactional(readOnly = true)
	public Page<HotelProjection> findAll() {
		log.info("Fetching all hotels");
		return this.hotelService.findAll();
	}

}
