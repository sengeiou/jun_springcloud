/*
 * Copyright (c) 2019-2029, Dreamlu 卢春梦 (596392912@qq.com & www.dreamlu.net).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dreamlu.mica.servlet.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 更改html请求异常为ajax
 *
 * @author Wujun
 */
public class MicaErrorController extends BasicErrorController {
	private final ObjectMapper objectMapper;

	public MicaErrorController(ObjectMapper objectMapper,
							   ErrorAttributes errorAttributes,
							   ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
		this.objectMapper = objectMapper;
	}

	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
		HttpStatus status = getStatus(request);
		response.setStatus(status.value());
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setObjectMapper(objectMapper);
		view.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		return new ModelAndView(view, body);
	}
}
