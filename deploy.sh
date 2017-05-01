#!/bin/bash
#
# 脚本用来在同一机器中部署 PROJECTS 的代码
#
stty erase ^H 
SVN_URL=svn://hmsh.com/base/test
PWD=`pwd`
WORK_DIR=~/works
BAK_DIR=~/works-bak
SLEEP_SECOND=1
PROJECTS=(all admin-service admin-wms-service admin-web)
PROJECTS_COUNT=$((${#PROJECTS[@]}-1))
helpinfo(){
	echo -e "用法: $0 {start|stop|deploy} 来部署代码 "
	exit 1
}
check_status(){
	if [ $1 -eq 0 ];then
		echo -e "\033[32m [成功] \033[0m"
	else
		echo -e "\033[31m [失败] \033[0m"
		exit 1
	fi
}
check_status_not_exist(){
	if [ $1 -eq 0 ];then
		echo -e "\033[32m [成功] \033[0m"
	else
		echo -e "\033[31m [失败] \033[0m"
	fi
}
check_dir(){
	if [ -w $1 ];then
		check_status 0
	elif [ ! -d $1 ];then
		mkdir $1 >/dev/null 
		check_status $?
	else
		check_status 1
	fi
}
svn_version(){
	echo `svn info $1 |grep "最后修改的版本:" |awk '{print $2}'`
}
deploy(){
	svn info $SVN_URL/$1 >/dev/null 
	if [ ! $? -eq 0 ];then
		echo -e "项目 $1 不在SVN上,跳过该项目 \033[31m [失败] \033[0m "
		SLEEP_SECOND=0
	elif [ ! -d  $WORK_DIR/$1 ];then 
        pull_start $1
	elif [ $(svn_version $WORK_DIR/$1) -lt $(svn_version $SVN_URL/$1) ];then
        backup $1
		pull_start $1
	else
		echo -e "项目$1没有变化，不需要重新部署. \033[32m [成功] \033[0m"
		SLEEP_SECOND=0
	fi
}
backup(){
    if [ -d $WORK_DIR/$1 ];then
        stop $1
        TIME_STAMP=`date "+%Y%m%d%H%M"`
        echo -e "备份原来项目:$1 到 $BAK_DIR/$1-$TIME_STAMP \c"
        mv $WORK_DIR/$1 $BAK_DIR/$1-$TIME_STAMP  >/dev/null 
        check_status $?
    fi
}
pull_start(){
        cd $WORK_DIR
		echo -e "从SVN上拉取$1的部署文件 \c"
		svn co $SVN_URL/$1 --username code --password code@hmsh.com >/dev/null 
		check_status $?
		echo -e "启动项目$1 \c"
		chmod +x $WORK_DIR/$1/bin/*.sh >/dev/null 
		sh $WORK_DIR/$1/bin/start.sh >/dev/null 
		check_status_not_exist $?
		SLEEP_SECOND=1
}
pre_deploy(){
	if [ x"$1" == x ] ;then
		exit 1
	elif [ "$1" == "all" ] ;then
		echo "按顺序部署所有项目."
		for i in ${!PROJECTS[@]};do
			if [ $i -gt 0 ];then
				deploy ${PROJECTS[$i]}
				sleep $SLEEP_SECOND
			fi
		done	
	else
		echo "部署指定项目:$1"
		deploy $1
	fi
}
stop(){
	if [ -d $WORK_DIR/$1 ];then
		echo -e "暂停项目:$1 \c"
		sh $WORK_DIR/$1/bin/stop.sh >/dev/null 
		check_status $?
	else
		echo -e "项目$1不存在.\c"
		check_status 1
	fi
}
pre_stop(){
	if [ x"$1" == x ] ;then
		exit 1
	elif [ "$1" == "all" ] ;then
		echo "按顺序暂停所有项目."
		for i in ${!PROJECTS[@]};do
			if [ $i -gt 0 ];then
				stop ${PROJECTS[$i]}
			fi
		done	
	else
		echo "暂停指定项目:$1"
		stop $1
	fi
}
start(){
	if [ -d $WORK_DIR/$1 ];then
		echo -e "启动项目:$1 \c"
		sh $WORK_DIR/$1/bin/start.sh >/dev/null 
		if [  $? -eq 0 ];then
			echo -e "\033[32m [成功] \033[0m"
			SLEEP_SECOND=1
		else
			echo -e "\033[31m [失败] \033[0m"
			SLEEP_SECOND=0
		fi
	else
		echo -e "项目$1不存在.\c"
		SLEEP_SECOND=0
		check_status 1
	fi
}
pre_start(){
	if [ x"$1" == x ] ;then
		exit 1
	elif [ "$1" == "all" ] ;then
		echo "按顺序启动所有项目."
		for i in ${!PROJECTS[@]};do
			if [ $i -gt 0 ];then
				start ${PROJECTS[$i]}
				sleep $SLEEP_SECOND
			fi
		done	
	else
		echo "启动指定项目:$1"
		start $1
	fi
}
prepare(){
	echo "该脚本只做一次项目备份,请慎重使用,如需回滚,请手动处理!!!"
	echo "正在检查参数是否正确,目录是否有写入权限:"
	echo -e "检查SVN基本目录链接===>$SVN_URL \c"
	svn info $SVN_URL >/dev/null 
	check_status $?
	echo -e "项目运行目录===>$WORK_DIR \c"
	check_dir $WORK_DIR
	echo -e "项目备份目录===>$BAK_DIR \c"
	check_dir $BAK_DIR
}
case $1 in 
start)
	prepare
	echo -e "允许启动的项目(all为所有):${PROJECTS[@]}"
	echo -n "请输入要启动的项目:"
	read project
	pre_start $project
;;
stop)
	prepare
	echo -e "允许停止的项目(all为所有):${PROJECTS[@]}"
	echo -n "请输入要停止的项目:"
	read project
	pre_stop $project
;;
deploy)
	prepare
	echo -e "允许部署的项目(all为所有):${PROJECTS[@]}"
	echo -n "请输入部署的项目:"
	read project
	pre_deploy $project
;;
*)
	helpinfo
;;
esac
cd $PWD
