package com.freehoon.web.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.board.service.BoardService;

@RestController
@RequestMapping(value="/restBoard")
public class RestBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestBoardController.class);
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/getReplyList", method=RequestMethod.POST)
	public List<ReplyVO> getReplyList(@RequestParam("bid") int bid ) throws Exception {
		return boardService.getReplyList(bid);
	}
	
	@RequestMapping(value="/saveReply", method=RequestMethod.POST)
	public Map<String, Object> saveReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			boardService.saveReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "false");
		}
		
		return result;
	}
	
	@RequestMapping(value="/deleteReply", method=RequestMethod.POST)
	public void deleteReply(@RequestParam("rid") int rid) throws Exception {
		boardService.deleteReply(rid);
	}
	
	@RequestMapping(value="/updateReply", method=RequestMethod.POST)
	public void updateReply(@RequestBody ReplyVO replyVO) throws Exception {
		boardService.updateReply(replyVO);
	}

}
