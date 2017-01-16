using JobDescriptionCsharp.domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.repository
{
    public interface IRepository<GenericType> where GenericType : Entity
    {
        void add(GenericType item);
        void remove(GenericType item);
        void update(GenericType item);
        int getLastId();
        GenericType getEntityById(int id);
        List<GenericType> getAll();
    }
}
