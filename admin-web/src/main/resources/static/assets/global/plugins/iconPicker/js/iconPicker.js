/*
 * Bootstrap 3.3.6 IconPicker - jQuery plugin for Icon selection
 *
 * Copyright (c) 20013 A. K. M. Rezaul Karim<titosust@gmail.com>
 * Modifications (c) 20015 Paden Clayton<fasttracksites.com>
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 * Project home:
 *   https://github.com/titosust/Bootstrap-icon-picker
 *
 * Version:  1.0.1
 *
 */

(function($) {

    $.fn.iconPicker = function( options ) {
        
        var mouseOver=false;
        var $popup=null;
        var icons=new Array("icon-bell","fa fa-plus","fa fa-bolt","fa fa-bell-o","fa fa-bullhorn","icon-envelope-open","icon-calendar","fa fa-angle-down","icon-user","icon-rocket","icon-lock","icon-key","icon-logout","icon-close","icon-magnifier","icon-home","icon-bar-chart","icon-bulb","icon-graph","icon-diamond","icon-puzzle","icon-settings","icon-briefcase","icon-wallet","icon-pointer","icon-layers","icon-feed","icon-paper-plane"," icon-wrench","icon-basket","icon-tag","icon-docs","icon-clock","icon-check","icon-envelope","icon-notebook","icon-user-female","icon-user-following","icon-users","icon-lock-open","icon-social-dribbble","icon-info","icon-call-end","icon-wrench","icon-pencil","icon-note","icon-folder","icon-power","icon-star","icon-camera","icon-link","icon-globe","fa fa-circle","icon-shield","icon-bag","fa fa-500px","fa fa-amazon","fa fa-balance-scale","fa fa-battery-0","fa fa-battery-1","fa fa-battery-2","fa fa-battery-3","fa fa-battery-4","fa fa-battery-empty","fa fa-battery-full","fa fa-battery-half","fa fa-battery-quarter","fa fa-battery-three-quarters","fa fa-black-tie","fa fa-calendar-check-o","fa fa-calendar-minus-o","fa fa-calendar-plus-o","fa fa-calendar-times-o","fa fa-cc-diners-club","fa fa-cc-jcb","fa fa-chrome","fa fa-clone","fa fa-commenting","fa fa-commenting-o","fa fa-contao","fa fa-creative-commons","fa fa-expeditedssl","fa fa-firefox","fa fa-fonticons","fa fa-genderless","fa fa-get-pocket","fa fa-gg","fa fa-gg-circle","fa fa-hand-grab-o","fa fa-hand-lizard-o","fa fa-hand-paper-o","fa fa-hand-peace-o","fa fa-hand-pointer-o","fa fa-hand-rock-o","fa fa-hand-scissors-o","fa fa-hand-spock-o","fa fa-hand-stop-o","fa fa-hourglass","fa fa-hourglass-1","fa fa-hourglass-2","fa fa-hourglass-3","fa fa-hourglass-end","fa fa-hourglass-half","fa fa-hourglass-o","fa fa-hourglass-start","fa fa-houzz","fa fa-i-cursor","fa fa-industry","fa fa-internet-explorer","fa fa-map","fa fa-map-o","fa fa-map-pin","fa fa-map-signs","fa fa-mouse-pointer","fa fa-object-group","fa fa-object-ungroup","fa fa-odnoklassniki","fa fa-odnoklassniki-square","fa fa-opencart","fa fa-opera","fa fa-optin-monster","fa fa-registered","fa fa-safari","fa fa-sticky-note","fa fa-sticky-note-o","fa fa-television","fa fa-trademark","fa fa-tripadvisor","fa fa-tv","fa fa-vimeo","fa fa-wikipedia-w","fa fa-y-combinator","fa fa-yc","fa fa-adjust","fa fa-anchor","fa fa-archive","fa fa-area-chart","fa fa-arrows","fa fa-arrows-h","fa fa-arrows-v","fa fa-asterisk","fa fa-at","fa fa-automobile","fa fa-ban","fa fa-bank","fa fa-bar-chart","fa fa-bar-chart-o","fa fa-barcode","fa fa-bars","fa fa-bed","fa fa-beer","fa fa-bell","fa fa-bell-slash","fa fa-bell-slash-o","fa fa-bicycle","fa fa-binoculars","fa fa-birthday-cake","fa fa-bomb","fa fa-book","fa fa-bookmark","fa fa-bookmark-o","fa fa-briefcase","fa fa-bug","fa fa-building","fa fa-building-o","fa fa-bullseye","fa fa-bus","fa fa-cab","fa fa-calculator","fa fa-calendar","fa fa-calendar-o","fa fa-camera","fa fa-camera-retro","fa fa-car","fa fa-caret-square-o-down","fa fa-caret-square-o-left","fa fa-caret-square-o-right","fa fa-caret-square-o-up","fa fa-cart-arrow-down","fa fa-cart-plus","fa fa-cc","fa fa-certificate","fa fa-check","fa fa-check-circle","fa fa-check-circle-o","fa fa-check-square","fa fa-check-square-o","fa fa-child","fa fa-circle-o","fa fa-circle-o-notch","fa fa-circle-thin","fa fa-clock-o","fa fa-close","fa fa-cloud","fa fa-cloud-download","fa fa-cloud-upload","fa fa-code","fa fa-code-fork","fa fa-coffee","fa fa-cog","fa fa-cogs","fa fa-comment","fa fa-comment-o","fa fa-comments","fa fa-comments-o","fa fa-compass","fa fa-copyright","fa fa-credit-card","fa fa-crop","fa fa-crosshairs","fa fa-cube","fa fa-cubes","fa fa-cutlery","fa fa-dashboard","fa fa-database","fa fa-desktop","fa fa-diamond","fa fa-dot-circle-o","fa fa-download","fa fa-edit","fa fa-ellipsis-h","fa fa-ellipsis-v","fa fa-envelope","fa fa-envelope-o","fa fa-envelope-square","fa fa-eraser","fa fa-exchange","fa fa-exclamation","fa fa-exclamation-circle","fa fa-exclamation-triangle","fa fa-external-link","fa fa-external-link-square","fa fa-eye","fa fa-eye-slash","fa fa-eyedropper","fa fa-fax","fa fa-feed","fa fa-female","fa fa-fighter-jet","fa fa-file-archive-o","fa fa-file-audio-o","fa fa-file-code-o","fa fa-file-excel-o","fa fa-file-image-o","fa fa-file-movie-o","fa fa-file-pdf-o","fa fa-file-photo-o","fa fa-file-picture-o","fa fa-file-powerpoint-o","fa fa-file-sound-o","fa fa-file-video-o","fa fa-file-word-o","fa fa-file-zip-o","fa fa-film","fa fa-filter","fa fa-fire","fa fa-fire-extinguisher","fa fa-flag","fa fa-flag-checkered","fa fa-flag-o","fa fa-flash","fa fa-flask","fa fa-folder","fa fa-folder-o","fa fa-folder-open","fa fa-folder-open-o","fa fa-frown-o","fa fa-futbol-o","fa fa-gamepad","fa fa-gavel","fa fa-gear","fa fa-gears","fa fa-gift","fa fa-glass","fa fa-globe","fa fa-graduation-cap","fa fa-group","fa fa-hdd-o","fa fa-headphones","fa fa-heart","fa fa-heart-o","fa fa-heartbeat","fa fa-history","fa fa-home","fa fa-hotel","fa fa-image","fa fa-inbox","fa fa-info","fa fa-info-circle","fa fa-institution","fa fa-key","fa fa-keyboard-o","fa fa-language","fa fa-laptop","fa fa-leaf","fa fa-legal","fa fa-lemon-o","fa fa-level-down","fa fa-level-up","fa fa-life-bouy","fa fa-life-buoy","fa fa-life-ring","fa fa-life-saver","fa fa-lightbulb-o","fa fa-line-chart","fa fa-location-arrow","fa fa-lock","fa fa-magic","fa fa-magnet","fa fa-mail-forward","fa fa-mail-reply","fa fa-mail-reply-all","fa fa-male","fa fa-map-marker","fa fa-meh-o","fa fa-microphone","fa fa-microphone-slash","fa fa-minus","fa fa-minus-circle","fa fa-minus-square","fa fa-minus-square-o","fa fa-mobile","fa fa-mobile-phone","fa fa-money","fa fa-moon-o","fa fa-mortar-board","fa fa-motorcycle","fa fa-music","fa fa-navicon","fa fa-newspaper-o","fa fa-paint-brush","fa fa-paper-plane","fa fa-paper-plane-o","fa fa-paw","fa fa-pencil","fa fa-pencil-square","fa fa-pencil-square-o","fa fa-phone","fa fa-phone-square","fa fa-photo","fa fa-picture-o","fa fa-pie-chart","fa fa-plane","fa fa-plug","fa fa-plus-circle","fa fa-plus-square","fa fa-plus-square-o","fa fa-power-off","fa fa-print","fa fa-puzzle-piece","fa fa-qrcode","fa fa-question","fa fa-question-circle","fa fa-quote-left","fa fa-quote-right","fa fa-random","fa fa-recycle","fa fa-refresh","fa fa-remove","fa fa-reorder","fa fa-reply","fa fa-reply-all","fa fa-retweet","fa fa-road","fa fa-rocket","fa fa-rss","fa fa-rss-square","fa fa-search","fa fa-search-minus","fa fa-search-plus","fa fa-send","fa fa-send-o","fa fa-server","fa fa-share","fa fa-share-alt","fa fa-share-alt-square","fa fa-share-square","fa fa-share-square-o","fa fa-shield","fa fa-ship","fa fa-shopping-cart","fa fa-sign-in","fa fa-sign-out","fa fa-signal","fa fa-sitemap","fa fa-sliders","fa fa-smile-o","fa fa-soccer-ball-o","fa fa-sort","fa fa-sort-alpha-asc","fa fa-sort-alpha-desc","fa fa-sort-amount-asc","fa fa-sort-amount-desc","fa fa-sort-asc","fa fa-sort-desc","fa fa-sort-down","fa fa-sort-numeric-asc","fa fa-sort-numeric-desc","fa fa-sort-up","fa fa-space-shuttle","fa fa-spinner","fa fa-spoon","fa fa-square","fa fa-square-o","fa fa-star","fa fa-star-half","fa fa-star-half-empty","fa fa-star-half-full","fa fa-star-half-o","fa fa-star-o","fa fa-street-view","fa fa-suitcase","fa fa-sun-o","fa fa-support","fa fa-tablet","fa fa-tachometer","fa fa-tag","fa fa-tags","fa fa-tasks","fa fa-taxi","fa fa-terminal","fa fa-thumb-tack","fa fa-thumbs-down","fa fa-thumbs-o-down","fa fa-thumbs-o-up","fa fa-thumbs-up","fa fa-ticket","fa fa-times","fa fa-times-circle","fa fa-times-circle-o","fa fa-tint","fa fa-toggle-down","fa fa-toggle-left","fa fa-toggle-off","fa fa-toggle-on","fa fa-toggle-right","fa fa-toggle-up","fa fa-trash","fa fa-trash-o","fa fa-tree","fa fa-trophy","fa fa-truck","fa fa-tty","fa fa-umbrella","fa fa-university","fa fa-unlock","fa fa-unlock-alt","fa fa-unsorted","fa fa-upload","fa fa-user","fa fa-user-plus","fa fa-user-secret","fa fa-user-times","fa fa-users","fa fa-video-camera","fa fa-volume-down","fa fa-volume-off","fa fa-volume-up","fa fa-warning","fa fa-wheelchair","fa fa-wifi","fa fa-wrench","fa fa-hand-o-down","fa fa-hand-o-left","fa fa-hand-o-right","fa fa-hand-o-up","fa fa-ambulance","fa fa-subway","fa fa-train","fa fa-intersex","fa fa-mars","fa fa-mars-double","fa fa-mars-stroke","fa fa-mars-stroke-h","fa fa-mars-stroke-v","fa fa-mercury","fa fa-neuter","fa fa-transgender","fa fa-transgender-alt","fa fa-venus","fa fa-venus-double","fa fa-venus-mars","fa fa-file","fa fa-file-o","fa fa-file-text","fa fa-file-text-o","fa fa-info-circle fa-lg fa-li","fa fa-cc-amex","fa fa-cc-discover","fa fa-cc-mastercard","fa fa-cc-paypal","fa fa-cc-stripe","fa fa-cc-visa","fa fa-google-wallet","fa fa-paypal","fa fa-bitcoin","fa fa-btc","fa fa-cny","fa fa-dollar","fa fa-eur","fa fa-euro","fa fa-gbp","fa fa-ils","fa fa-inr","fa fa-jpy","fa fa-krw","fa fa-rmb","fa fa-rouble","fa fa-rub","fa fa-ruble","fa fa-rupee","fa fa-shekel","fa fa-sheqel","fa fa-try","fa fa-turkish-lira","fa fa-usd","fa fa-won","fa fa-yen","fa fa-align-center","fa fa-align-justify","fa fa-align-left","fa fa-align-right","fa fa-bold","fa fa-chain","fa fa-chain-broken","fa fa-clipboard","fa fa-columns","fa fa-copy","fa fa-cut","fa fa-dedent","fa fa-files-o","fa fa-floppy-o","fa fa-font","fa fa-header","fa fa-indent","fa fa-italic","fa fa-link","fa fa-list","fa fa-list-alt","fa fa-list-ol","fa fa-list-ul","fa fa-outdent","fa fa-paperclip","fa fa-paragraph","fa fa-paste","fa fa-repeat","fa fa-rotate-left","fa fa-rotate-right","fa fa-save","fa fa-scissors","fa fa-strikethrough","fa fa-subscript","fa fa-superscript","fa fa-table","fa fa-text-height","fa fa-text-width","fa fa-th","fa fa-th-large","fa fa-th-list","fa fa-underline","fa fa-undo","fa fa-unlink","fa fa-angle-double-down","fa fa-angle-double-left","fa fa-angle-double-right","fa fa-angle-double-up","fa fa-angle-left","fa fa-angle-right","fa fa-angle-up","fa fa-arrow-circle-down","fa fa-arrow-circle-left","fa fa-arrow-circle-o-down","fa fa-arrow-circle-o-left","fa fa-arrow-circle-o-right","fa fa-arrow-circle-o-up","fa fa-arrow-circle-right","fa fa-arrow-circle-up","fa fa-arrow-down","fa fa-arrow-left","fa fa-arrow-right","fa fa-arrow-up","fa fa-arrows-alt","fa fa-caret-down","fa fa-caret-left","fa fa-caret-right","fa fa-caret-up","fa fa-chevron-circle-down","fa fa-chevron-circle-left","fa fa-chevron-circle-right","fa fa-chevron-circle-up","fa fa-chevron-down","fa fa-chevron-left","fa fa-chevron-right","fa fa-chevron-up","fa fa-long-arrow-down","fa fa-long-arrow-left","fa fa-long-arrow-right","fa fa-long-arrow-up","fa fa-backward","fa fa-compress","fa fa-eject","fa fa-expand","fa fa-fast-backward","fa fa-fast-forward","fa fa-forward","fa fa-pause","fa fa-play","fa fa-play-circle","fa fa-play-circle-o","fa fa-step-backward","fa fa-step-forward","fa fa-stop","fa fa-youtube-play","fa fa-adn","fa fa-android","fa fa-angellist","fa fa-apple","fa fa-behance","fa fa-behance-square","fa fa-bitbucket","fa fa-bitbucket-square","fa fa-buysellads","fa fa-codepen","fa fa-connectdevelop","fa fa-css3","fa fa-dashcube","fa fa-delicious","fa fa-deviantart","fa fa-digg","fa fa-dribbble","fa fa-dropbox","fa fa-drupal","fa fa-empire","fa fa-facebook","fa fa-facebook-f","fa fa-facebook-official","fa fa-facebook-square","fa fa-flickr","fa fa-forumbee","fa fa-foursquare","fa fa-ge","fa fa-git","fa fa-git-square","fa fa-github","fa fa-github-alt","fa fa-github-square","fa fa-gittip","fa fa-google","fa fa-google-plus","fa fa-google-plus-square","fa fa-gratipay","fa fa-hacker-news","fa fa-html5","fa fa-instagram","fa fa-ioxhost","fa fa-joomla","fa fa-jsfiddle","fa fa-lastfm","fa fa-lastfm-square","fa fa-leanpub","fa fa-linkedin","fa fa-linkedin-square","fa fa-linux","fa fa-maxcdn","fa fa-meanpath","fa fa-medium","fa fa-openid","fa fa-pagelines","fa fa-pied-piper","fa fa-pied-piper-alt","fa fa-pinterest","fa fa-pinterest-p","fa fa-pinterest-square","fa fa-qq","fa fa-ra","fa fa-rebel","fa fa-reddit","fa fa-reddit-square","fa fa-renren","fa fa-sellsy","fa fa-shirtsinbulk","fa fa-simplybuilt","fa fa-skyatlas","fa fa-skype","fa fa-slack","fa fa-slideshare","fa fa-soundcloud","fa fa-spotify","fa fa-stack-exchange","fa fa-stack-overflow","fa fa-steam","fa fa-steam-square","fa fa-stumbleupon","fa fa-stumbleupon-circle","fa fa-tencent-weibo","fa fa-trello","fa fa-tumblr","fa fa-tumblr-square","fa fa-twitch","fa fa-twitter","fa fa-twitter-square","fa fa-viacoin","fa fa-vimeo-square","fa fa-vine","fa fa-vk","fa fa-wechat","fa fa-weibo","fa fa-weixin","fa fa-whatsapp","fa fa-windows","fa fa-wordpress","fa fa-xing","fa fa-xing-square","fa fa-y-combinator-square","fa fa-yahoo","fa fa-yc-square","fa fa-yelp","fa fa-youtube","fa fa-youtube-square","fa fa-h-square","fa fa-hospital-o","fa fa-medkit","fa fa-stethoscope","fa fa-user-md","icon-login","icon-speech","icon-arrow-left","icon-paper-clip","icon-arrow-up");
        var settings = $.extend({
        	
        }, options);
        return this.each( function() {
        	element=this;
            if(!settings.buttonOnly && $(this).data("iconPicker")==undefined ){
            	$this=$(this).addClass("form-control");
            	$wraper=$("<div/>",{class:"input-group"});
            	$this.wrap($wraper);

            	$button=$("<span class=\"input-group-addon pointer\"><i class=\"glyphicon  glyphicon-picture\"></i></span>");
            	$this.after($button);
            	(function(ele){
	            	$button.click(function(){
			       		createUI(ele);
			       		showList(ele,icons);
	            	});
	            })($this);

            	$(this).data("iconPicker",{attached:true});
            }
        
	        function createUI($element){
	        	$popup=$('<div/>',{
	        		css: {
		        		'top':$element.offset().top+$element.outerHeight()+6,
		        		'left':$element.offset().left
		        	},
		        	class:'icon-popup'
	        	})

	        	$popup.html('<div class="ip-control"> \
						          <ul> \
						            <li><a href="javascript:;" class="btn" data-dir="-1"><span class="glyphicon  glyphicon-fast-backward"></span></a></li> \
						            <li><input type="text" class="ip-search glyphicon  glyphicon-search" placeholder="Search" /></li> \
						            <li><a href="javascript:;"  class="btn" data-dir="1"><span class="glyphicon  glyphicon-fast-forward"></span></a></li> \
						          </ul> \
						      </div> \
						     <div class="icon-list"> </div> \
					         ').appendTo("body");
	        	
	        	
	        	$popup.addClass('dropdown-menu').show();
				$popup.mouseenter(function() {  mouseOver=true;  }).mouseleave(function() { mouseOver=false;  });

	        	var lastVal="", start_index=0,per_page=30,end_index=start_index+per_page;
	        	$(".ip-control .btn",$popup).click(function(e){
	                e.stopPropagation();
	                var dir=$(this).attr("data-dir");
	                start_index=start_index+per_page*dir;
	                start_index=start_index<0?0:start_index;
	                if(start_index+per_page<=210){
	                  $.each($(".icon-list>ul li"),function(i){
	                      if(i>=start_index && i<start_index+per_page){
	                         $(this).show();
	                      }else{
	                        $(this).hide();
	                      }
	                  });
	                }else{
	                  start_index=180;
	                }
	            });
	        	
	        	$('.ip-control .ip-search',$popup).on("keyup",function(e){
	                if(lastVal!=$(this).val()){
	                    lastVal=$(this).val();
	                    if(lastVal==""){
	                    	showList(icons);
	                    }else{
	                    	showList($element, $(icons)
							        .map(function(i,v){ 
								            if(v.toLowerCase().indexOf(lastVal.toLowerCase())!=-1){return v} 
								        }).get());
						}
	                    
	                }
	            });  
	        	$(document).mouseup(function (e){
				    if (!$popup.is(e.target) && $popup.has(e.target).length === 0) {
				        removeInstance();
				    }
				});

	        }
	        function removeInstance(){
	        	$(".icon-popup").remove();
	        }
	        function showList($element,arrLis){
	        	$ul=$("<ul>");
	        	console.log(arrLis);
	        	for (var i in arrLis) {
	        		$ul.append("<li><a href=\"#\" title=\""+arrLis[i]+"\"><i class=\""+arrLis[i]+"\"></i></a></li>");
	        	};

	        	$(".icon-list",$popup).html($ul);
	        	$(".icon-list li a",$popup).click(function(e){
	        		e.preventDefault();
	        		var title=$(this).attr("title");
	        		$element.val("glyphicon glyphicon-"+title);
	        		removeInstance();
	        	});
	        }

        });
    }

}(jQuery));
