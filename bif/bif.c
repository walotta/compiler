#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

void _glb_print(char* str){
    printf("%s",str);
}

void _glb_println(char* str){
    printf("%s\n",str);
}

void _glb_printInt(int n){
    printf("%d",n);
}

void _glb_printlnInt(int n){
    printf("%d\n",n);
}

char* _glb_getString(){
    char* str=malloc(sizeof(char)*1024);
    scanf("%s",str);
    return str;
}

int _glb_getInt(){
    int n;
    scanf("%d",&n);
    return n;
}

char* _glb_toString(int i){
    char* str=malloc(sizeof(char)*16);
    sprintf(str,"%d",i);
    return str;
}

int _str_length(char* str){
    return strlen(str);
}

char* _str_substring(char* str,int left,int right){
    char* ans=malloc(sizeof(char)*(right-left+1));
    memcpy(ans,str+left,right-left);
    ans[right-left]='\0';
    return ans;
}

char* _str_addstring(char* str1,char* str2){
    char* ans=malloc(sizeof(char)*1024);
    strcpy(ans,str1);
    strcat(ans,str2);
    return ans;
}

int _str_parseInt(char* str){
    int ans;
    sscanf(str,"%d",&ans);
    return ans;
}

char _str_ord(char* str,int pos){
    return str[pos];
}

bool _str_eq(char* str1,char* str2){
    return strcmp(str1,str2)==0;
}
bool _str_ne(char* str1,char* str2){
    return strcmp(str1,str2)!=0;
}
bool _str_lt(char* str1,char* str2){
    return strcmp(str1,str2)<0;
}
bool _str_le(char* str1,char* str2){
    return strcmp(str1,str2)<=0;
}
bool _str_gt(char* str1,char* str2){
    return strcmp(str1,str2)>0;
}
bool _str_ge(char* str1,char* str2){
    return strcmp(str1,str2)>=0;
}