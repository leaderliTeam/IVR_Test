cal(){
   git log --all --shortstat   --author "$1" --after '2 day ago' --before '1 day ago' \
    | grep "files\? changed" \
    | awk '{files+=$1; inserted+=$4; deleted+=$6} END \
           {print "'$1' --> lines inserted:", inserted, "lines deleted:", deleted}'  
}





cal dengqiankun
cal zhang
cal wleecc
cal simolegiue