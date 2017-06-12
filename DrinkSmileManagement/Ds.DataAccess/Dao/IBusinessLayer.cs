using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Ds.DataAccess.EF;
using Ds.DataAccess.Generic;

namespace Ds.DataAccess.Dao
{
    public interface IBusinessLayer
    {
        //Nhan Vien
        IList<ds_nhanvien> GetAllStaff();
        ds_nhanvien GetStaffByName(string name);
        void AddStaff(params ds_nhanvien[] staff);
        void UpdateStaff(params ds_nhanvien[] staff);
        void RemoveStaff(params ds_nhanvien[] staff);
        //Loai Nhan Vien
        void AddTypeStaff(params ds_loainhanvien[] type);
        void UpdateTypeStaff(params ds_loainhanvien[] type);
        void RemoveTypeStaff(params ds_loainhanvien[] type);
    }
}
